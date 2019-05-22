package by.training.action;

import by.training.entity.User;
import by.training.exception.PersistentException;
import by.training.service.UserService;
import by.training.service.servicefactory.CreatorService;
import by.training.service.servicefactory.ServiceImplFactory;
import by.training.service.servicefactory.UserServiceImplFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowPopularPeopleAction extends Action {
    private static Logger LOGGER = LogManager.getLogger(LogoutAction.class);

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        ServiceImplFactory factory = new UserServiceImplFactory();
        creator = new CreatorService();
        UserService service = creator.createService(factory);
        List<User> users = service.findAll();
        request.setAttribute("users", users);
        return null;
    }
}
