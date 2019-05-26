package by.training.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

import by.training.action.Action;
import by.training.action.ActionManager;
import by.training.action.ActionManagerFactory;
import by.training.action.Trimming;
import by.training.dao.pool.ConnectionPool;
import by.training.exception.PersistentException;
import by.training.service.servicefactory.CreatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.training.action.actionenum.ActionEnum.findAction;

public class DispatcherServlet extends HttpServlet {
    private static Logger LOGGER = LogManager.getLogger(DispatcherServlet.class);

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/think?useUnicode=true&characterEncoding=UTF-8";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";
    public static final int DB_POOL_START_SIZE = 10;
    public static final int DB_POOL_MAX_SIZE = 1000;
    public static final int DB_POOL_CHECK_CONNECTION_TIMEOUT = 0;

    @Override
    public void init() {
        try {
            ConnectionPool.getInstance().init(DB_DRIVER, DB_URL, DB_USER, DB_PASSWORD, DB_POOL_START_SIZE, DB_POOL_MAX_SIZE, DB_POOL_CHECK_CONNECTION_TIMEOUT);
        } catch(PersistentException e) {
            LOGGER.error("It is impossible to initialize application", e);
            destroy();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
/*        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();
        LOGGER.debug(String.format("Starting of processing of request for URI \"%s\"", uri));
        int beginAction = contextPath.length();
        int endAction = uri.lastIndexOf('.');
        String actionName;
        if(endAction >= 0) {
            actionName = uri.substring(beginAction, endAction);
        } else {
            actionName = uri.substring(beginAction);
        }
        Action action = findAction(actionName);
        String str = "str";
        if (action == null) {
            str = "null";
        }
        action.setName(actionName);
        request.setAttribute("test", action.getName() );
        request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);*/
        process(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Action action = (Action)request.getAttribute("action");
        try {
            HttpSession session = request.getSession(false);
            if(session != null) {
                @SuppressWarnings("unchecked")
                Map<String, Object> attributes = (Map<String, Object>)session.getAttribute("redirectedData");
                if(attributes != null) {
                    for(String key : attributes.keySet()) {
                        request.setAttribute(key, attributes.get(key));
                    }
                    session.removeAttribute("redirectedData");
                }
            }
            ActionManager actionManager = ActionManagerFactory.getManager(new CreatorService());
            Action.Forward forward = actionManager.execute(action, request, response);
            actionManager.close();
            if(session != null && forward != null && !forward.getAttributes().isEmpty()) {
                session.setAttribute("redirectedData", forward.getAttributes());
            }
            String requestedUri = request.getRequestURI();
            if(forward != null && forward.isRedirect()) {
                String redirectedUri = request.getContextPath() + forward.getForward();
                LOGGER.debug(String.format("Request for URI \"%s\" id redirected to URI \"%s\"", requestedUri, redirectedUri));
                response.sendRedirect(redirectedUri);
            } else {
                String jspPage;
                if(forward != null) {
                   /* if(forward.getForward().contains("?")) {
                        String sign = Trimming.TrimmSign(forward.getForward(), '?');
                        if ("?signin".equals(sign) || "?signup".equals(sign)) {
                            String uri = forward.getForward();
                            getServletContext().getRequestDispatcher("/WEB-INF/jsp" + uri).forward(request, response);
                        }
                    }*/
                    jspPage = forward.getForward();
                } else {
                    jspPage = action.getName() + ".jsp";
                }
                jspPage = "/WEB-INF/jsp" + jspPage;
                LOGGER.debug(String.format("Request for URI \"%s\" is forwarded to JSP \"%s\"", requestedUri, jspPage));
                getServletContext().getRequestDispatcher(jspPage).forward(request, response);
            }
        } catch(PersistentException e) {
            LOGGER.error("It is impossible to process request", e);
            request.setAttribute("error", "Ошибка обработки данных");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }

    public void destroy() {
        ConnectionPool.getInstance().destroy();
    }
}
