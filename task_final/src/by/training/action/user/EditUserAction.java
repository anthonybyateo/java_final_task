package by.training.action.user;

import by.training.action.Action;
import by.training.entity.User;
import by.training.exception.PersistentException;
import by.training.service.UserService;
import by.training.service.servicefactory.CreatorService;
import by.training.service.servicefactory.ServiceImplFactory;
import by.training.service.servicefactory.UserServiceImplFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditUserAction extends Action {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String date = request.getParameter("birthday");
        User user = (User) request.getSession().getAttribute("authorizedUser");
        if (name != null && lastname != null) {
            ServiceImplFactory factory = new UserServiceImplFactory();
            creator = new CreatorService();
            UserService service = creator.createService(factory);
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
            if (service.update(user)) {
                request.setAttribute("errorEdit",
                        "Successfully saving");
            } else {
                request.setAttribute("errorEdit",
                        "Impossiple to save");
            }
        }
        return null;
    }
}
