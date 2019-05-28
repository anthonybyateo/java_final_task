package by.training.action;

import by.training.entity.User;
import by.training.exception.PersistentException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction extends AuthorizedUserAction {
    private static Logger logger = LogManager.getLogger(LogoutAction.class);

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response)
            throws PersistentException {
        User user = getAuthorizedUser();
        if (user != null) {
            logger.info(String.format("user \"%s\" is logged out",
                    user.getLogin()));
            request.getSession(false).invalidate();
        }
        return new Forward("/popular_people.html");
    }
}
