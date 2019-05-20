package by.training.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.training.entity.Role;
import by.training.entity.User;
import by.training.exception.PersistentException;
import by.training.service.UserServiceImp;
import org.apache.log4j.Logger;

public class LoginAction extends Action {
    private static Logger logger = Logger.getLogger(LoginAction.class);

    @Override
    public Set<Role> getAllowRoles() {
        return null;
    }

    @Override
    public Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != null && password != null) {
            UserServiceImp service = factory.getService(UserServiceImp.class);
            User user = service.findByLoginAndPassword(login, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("authorizedUser", user);
                logger.info(String.format("user \"%s\" is logged in from %s (%s:%s)", login, request.getRemoteAddr(), request.getRemoteHost(), request.getRemotePort()));
                return new Forward("/index.html");
            } else {
                request.setAttribute("message", "Имя пользователя или пароль не опознанны");
                logger.info(String.format("user \"%s\" unsuccessfully tried to log in from %s (%s:%s)", login, request.getRemoteAddr(), request.getRemoteHost(), request.getRemotePort()));
            }
        }
        return null;
    }
}
