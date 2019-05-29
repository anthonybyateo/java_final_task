package by.training.controller.fIlter;

import by.training.action.Action;
import by.training.action.Trimming;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static by.training.action.actionenum.ActionEnum.findAction;

public class ActionFromUriFilter implements Filter {
    private static final Logger LOGGER =
            LogManager.getLogger(SecurityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
            LOGGER.debug(String.format("Starting of processing of request for "
                    + "URI \"%s\"", httpRequest.getRequestURI()));
            String actionName = Trimming.TrimmUri(httpRequest, '.');
            String actionPost = httpRequest.getParameter("actionPost");
            if(actionPost!=null && !actionPost.isEmpty()){
                actionName = actionPost;
            }
            Action action = findAction(actionName);
            if (action != null) {
                action.setName(actionName);
                httpRequest.setAttribute("action", action);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpRequest.setAttribute("error", String.format("Запрошенный"
                        + " адрес %s не может быть обработан сервером %s",
                        httpRequest.getRequestURI(), actionName));
                httpRequest.getServletContext()
                        .getRequestDispatcher("/WEB-INF/jsp/error.jsp")
                        .forward(servletRequest, servletResponse);
            }
        } else {
            LOGGER.error("It is impossible to use HTTP filter");
            servletRequest.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/error.jsp")
                    .forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
