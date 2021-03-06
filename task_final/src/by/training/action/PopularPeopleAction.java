package by.training.action;

import by.training.entity.User;
import by.training.exception.PersistentException;
import by.training.service.SubscriptionService;
import by.training.service.UserService;
import by.training.service.servicefactory.CreatorService;
import by.training.service.servicefactory.ServiceImplFactory;
import by.training.service.servicefactory.SubscriptionServiceImplFactory;
import by.training.service.servicefactory.UserServiceImplFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PopularPeopleAction extends Action {
    private static Logger LOGGER = LogManager
            .getLogger(PopularPeopleAction.class);

    @Override
    public Forward exec(HttpServletRequest request,
                        HttpServletResponse response)
            throws PersistentException {
        ServiceImplFactory factory = new UserServiceImplFactory();
        creator = new CreatorService();
        UserService userService = creator.createService(factory);
        List<User> users = userService.findAllOrderBySub();
        request.setAttribute("users", users);

        factory = new SubscriptionServiceImplFactory();
        SubscriptionService subscriptionService = creator.createService(factory);
        List<Integer> subscribers = subscriptionService
                .countSubscribersOrderByPopular();
        request.setAttribute("subscribers", subscribers);
        return null;
    }
}
