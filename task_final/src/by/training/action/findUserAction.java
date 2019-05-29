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
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        String search = request.getParameter("search");
        String lastname = search.split(" ")[0];
        String name = search.split(" ")[1];
        ServiceImplFactory factory = new UserServiceImplFactory();
        creator = new CreatorService();
        UserService userService = creator.createService(factory);
        List<User> users = userService.readByLastnameAndName(lastname, name);
        request.setAttribute("searchUsers", users);
        request.setAttribute("name", name);
        request.setAttribute("lastname", lastname);
        return new Forward("/people.jsp", false);
    }
}
