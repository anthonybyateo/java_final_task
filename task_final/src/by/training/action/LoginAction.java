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

    private static Map<Role, List<MenuItem>> menu = new ConcurrentHashMap<>();

    static {
        menu.put(Role.ADMINISTRATOR, new ArrayList<>(Arrays.asList(
                new MenuItem("/search/book/form.html", "поиск книг"),
                new MenuItem("/search/reader/form.html", "поиск читателей")
        )));
        menu.put(Role.MODERATOR, new ArrayList<>(Arrays.asList(
                new MenuItem("/reader/list.html", "читатели"),
                new MenuItem("/user/list.html", "сотрудники")
        )));
        menu.put(Role.USER, new ArrayList<>(Arrays.asList(
                new MenuItem("/author/list.html", "авторы")
        )));
    }

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
                session.setAttribute("menu", menu.get(user.getRole()));
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
