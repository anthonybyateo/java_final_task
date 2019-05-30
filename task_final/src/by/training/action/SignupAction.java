package by.training.action;

import by.training.entity.Role;
import by.training.entity.User;
import by.training.exception.PersistentException;
import by.training.service.UserService;
import by.training.service.servicefactory.CreatorService;
import by.training.service.servicefactory.ServiceImplFactory;
import by.training.service.servicefactory.UserServiceImplFactory;
import by.training.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignupAction extends Action {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response)
            throws PersistentException {
        String password = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String date = request.getParameter("birthday");
        creator = new CreatorService();
        UserService service = creator.createService(new UserServiceImplFactory());
        if (service.findByLogin(login) == null) {
            if (service.findByEmail(email) == null) {
                if (password != null && password.equals(confPassword)) {
                    User user = new User();
                    user.setLogin(login);
                    user.setPassword(password);
                    user.setEmail(email);
                    user.setName(name);
                    user.setLastname(lastname);
                    Date birthday = null;
                    try {
                        birthday = new SimpleDateFormat("yyyy-MM-dd")
                                        .parse(date);
                    } catch (ParseException e) {
                        birthday = new Date();
                    }
                    user.setBirthday(birthday);
                    user.setRole(Role.USER);
                    UserValidator validator = new UserValidator();
                    if (validator.validate(user) && service.save(user) != 0) {
                        HttpSession session = request.getSession();
                        session.setAttribute("authorizedUser", user);
                        request.setAttribute("test",
                                "authorizedUser");
                        return new Forward(Trimming.TrimmUri(request, ' '));
                    } else {
                        request.setAttribute("errorUp",
                                "Impossible to save, try later");
                    }
                } else {
                    request.setAttribute("errorUp",
                            "Repeat password is wrong");
                }
            } else {
                request.setAttribute("errorUp", "Email is used");
            }
        } else {
            request.setAttribute("errorUp", "Login is used");
        }
        return new Forward(Trimming.TrimmUri(request, '.')
                + ".jsp", false);
    }
}
