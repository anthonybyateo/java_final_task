package by.training.action;

import by.training.exception.PersistentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditAction extends Action {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email != null && password != null) {
            ServiceImplFactory factory = new UserServiceImplFactory();
            creator = new CreatorService();
            UserService service = creator.createService(factory);
            User user = service.findByEmailAndPassword(email, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("authorizedUser", user);
                LOGGER.info(String.format("user %s is logged in from"
                                + " %s (%s:%s)", email, request.getRemoteAddr(),
                        request.getRemoteHost(), request.getRemotePort()));
                return new Forward(Trimming.TrimmUri(request, '?'));

            } else {
                request.setAttribute("errorIn", "Email or password is wrong");
            }
        }
        return new Forward(Trimming.TrimmUri(request, '.')
                + ".jsp", false);
    }
}
