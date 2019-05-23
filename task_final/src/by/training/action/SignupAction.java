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

public class SignupAction extends Action {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        String password = request.getParameter("password");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String date = request.getParameter("date");
        creator = new CreatorService();
        UserService service = creator.createService(new UserServiceImplFactory());
        if (service.findByLogin(login) == null) {
            if (service.findByEmail(email) == null) {
                User user = new User();
                user.setLogin(login);
                user.setPassword(password);
                user.setEmail(email);
                user.setName(name);
                user.setLastname(lastname);
                user.setRole(Role.USER);
                //UserValidator validator = new UserValidator();
                if (/*validator.validate(user) &&*/ service.save(user) != 0) {
                    request.setAttribute("completeMessage",
                            "User created successfully");
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    return new Forward("/login.html");
                } else {
                    request.setAttribute("signuperror",
                            "User save error");
                    System.out.println("slllsl");
                    return new Forward("/error3.html" + login);
                }
            } else {
                request.setAttribute("signuperror",
                        "User with this email already exists");
            }
        } else {
            request.setAttribute("signuperror",
                    "User with this login already exists");
            return new Forward("/error2.html");
        }
        return new Forward("/error1.html");
    }
}