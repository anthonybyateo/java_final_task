package by.training.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import by.training.action.Action;
import by.training.action.ActionManager;
import by.training.action.ActionManagerFactory;
import by.training.dao.pool.ConnectionPool;
import by.training.exception.IncorrectFormDataException;
import by.training.exception.PersistentException;
import by.training.service.servicefactory.CreatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

@MultipartConfig
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
        process(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //process(request, response);
        Action action = (Action)request.getAttribute("action");
        if(!"XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            try {
                ActionManager actionManager = ActionManagerFactory.getManager(new CreatorService());
                Action.Forward forward = null;
                try {
                    forward = actionManager.execute(action, request, response);
                } catch (IncorrectFormDataException e) {
                    e.printStackTrace();
                }
                actionManager.close();
                String requestedUri = request.getRequestURI();
                if(forward != null) {
                    String redirectedUri = request.getContextPath() + forward.getForward();
                    LOGGER.debug(String.format("Request for URI \"%s\" id redirected to URI \"%s\"", requestedUri, redirectedUri));
                    response.sendRedirect(redirectedUri);
                }
            } catch(PersistentException e) {
                LOGGER.error("It is impossible to process request", e);
                request.setAttribute("error", "Ошибка обработки данных");
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            }

        } else {
            try {
                ActionManager actionManager = ActionManagerFactory.getManager(new CreatorService());
                Action.Forward forward = null;
                try {
                    forward = actionManager.execute(action, request, response);
                } catch (IncorrectFormDataException e) {
                    e.printStackTrace();
                }
                actionManager.close();
            } catch(PersistentException e) {
                LOGGER.error("It is impossible to process request", e);
                request.setAttribute("error", "Ошибка обработки данных");
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            }
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Action action = (Action)request.getAttribute("action");
        if(!"XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
        try {
            ActionManager actionManager = ActionManagerFactory.getManager(new CreatorService());
            Action.Forward forward = null;
            try {
                forward = actionManager.execute(action, request, response);
            } catch (IncorrectFormDataException e) {
                e.printStackTrace();
            }
            actionManager.close();
            String requestedUri = request.getRequestURI();
            if(forward != null && forward.isRedirect()) {
                String redirectedUri = request.getContextPath() + forward.getForward();
                LOGGER.debug(String.format("Request for URI \"%s\" id redirected to URI \"%s\"", requestedUri, redirectedUri));
                response.sendRedirect(redirectedUri);
            } else {
                String jspPage;
                if(forward != null) {
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

        } else {
            try {
                ActionManager actionManager = ActionManagerFactory.getManager(new CreatorService());
                Action.Forward forward = null;
                try {
                    forward = actionManager.execute(action, request, response);
                } catch (IncorrectFormDataException e) {
                    e.printStackTrace();
                }
                actionManager.close();
                         } catch(PersistentException e) {
                LOGGER.error("It is impossible to process request", e);
                request.setAttribute("error", "Ошибка обработки данных");
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            }
        }
    }

    public void destroy() {
        ConnectionPool.getInstance().destroy();
    }
}
