package by.training.action;

import by.training.entity.User;
import by.training.exception.PersistentException;
import by.training.service.UserService;
import by.training.service.servicefactory.CreatorService;
import by.training.service.servicefactory.ServiceImplFactory;
import by.training.service.servicefactory.UserServiceImplFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class findUserAction extends Action {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response)
            throws PersistentException {
        String[] search = request.getParameter("search").split("\\s");
        String lastname = "";
        String name = "";
        if (search.length >= 2) {
            lastname = search[0];
            name = search[1];
        }
        if (search.length == 1) {
            lastname = search[0];
            name = search[0];
        }
        ServiceImplFactory factory = new UserServiceImplFactory();
        creator = new CreatorService();
        UserService userService = creator.createService(factory);
        List<User> users = userService.readByLastnameAndName(lastname, name);
        request.setAttribute("searchUsers", users);
        return new Forward("/people.jsp",false);
    }
}
