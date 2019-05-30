package by.training.action;

import by.training.entity.User;
import by.training.exception.PersistentException;
import by.training.service.SubscriptionService;
import by.training.service.UserService;
import by.training.service.servicefactory.CreatorService;
import by.training.service.servicefactory.ServiceImplFactory;
import by.training.service.servicefactory.SubscriptionServiceImplFactory;
import by.training.service.servicefactory.UserServiceImplFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileAction extends Action {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response)
            throws PersistentException {
        long id;
        try {
            id = Long.parseLong(request.getParameter("id"));

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Id is wrong");
            return new Forward("/error.jsp", false);
        }
        creator = new CreatorService();
        ServiceImplFactory factory = new SubscriptionServiceImplFactory();
        SubscriptionService subscriptionService = creator.createService(factory);
        int subscriber = subscriptionService.countSubscribers(id);
        int subscription = subscriptionService.countSubscriptions(id);
        request.setAttribute("subscriber", subscriber);
        request.setAttribute("subscription", subscription);

        factory = new UserServiceImplFactory();
        UserService userService = creator.createService(factory);
        User user = userService.findById(id);
        request.setAttribute("user", user);

        creator.close();
        return null;
    }
}
