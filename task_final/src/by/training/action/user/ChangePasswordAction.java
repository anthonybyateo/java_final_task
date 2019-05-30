package by.training.action.user;

import by.training.entity.User;
import by.training.exception.PersistentException;
import by.training.service.UserService;
import by.training.service.servicefactory.CreatorService;
import by.training.service.servicefactory.UserServiceImplFactory;
import by.training.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordAction extends UserAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response)
            throws PersistentException {
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String confNewPassword = request.getParameter("confNewPassword");
        User user = (User) request.getSession().getAttribute("authorizedUser");
        long id = user.getId();
        UserValidator validator = new UserValidator();
        creator = new CreatorService();
        UserService service = creator.createService(new UserServiceImplFactory());
        user = service.findByEmailAndPassword(user.getEmail(), password);
        if (password != null && user != null) {
            if (validator.validateChangePassword(newPassword, confNewPassword)) {
                service.changePassword(id, newPassword);
                request.setAttribute("errorEdit",
                        "Successfully changing");
            } else {
                request.setAttribute("errorEdit",
                        "Confirmation of new password is wrong");
            }
        } else {
            request.setAttribute("errorEdit",
                    "Old password is wrong");
        }
        return new Forward("/edit.jsp", false);
    }
}
