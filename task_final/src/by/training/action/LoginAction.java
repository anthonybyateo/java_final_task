package by.training.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.training.entity.Role;
import by.training.entity.User;
import by.training.exception.PersistentException;
import by.training.service.UserService;
import by.training.service.servicefactory.CreatorService;
import by.training.service.servicefactory.ServiceImplFactory;
import by.training.service.servicefactory.UserServiceImplFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginAction extends Action {
    private static Logger LOGGER = LogManager.getLogger(LogoutAction.class);

    @Override
    public Set<Role> getAllowRoles() {
        return null;
    }

    @Override
    public Action.Forward exec(HttpServletRequest request,
                               HttpServletResponse response)
            throws PersistentException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email != null && password != null) {
            ServiceImplFactory factory = new UserServiceImplFactory();
            creator = new CreatorService();
            UserService service = creator.createService(factory);
            User user = service.findByEmailAndPassword(email, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("authorizedUser", user);
                LOGGER.info(String.format("user %s is logged in from"
                                + " %s (%s:%s)", email, request.getRemoteAddr(),
                        request.getRemoteHost(), request.getRemotePort()));
                return new Forward(Trimming.TrimmUri(request, '?'));

            } else {
                request.setAttribute("errorIn", "Email or password is wrong");
            }
        }
        return new Forward(Trimming.TrimmUri(request, '.')
                + ".jsp", false);
    }
}
