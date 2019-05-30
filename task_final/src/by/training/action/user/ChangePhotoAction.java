package by.training.action.user;

import by.training.entity.Img;
import by.training.entity.User;
import by.training.exception.IncorrectFormDataException;
import by.training.exception.PersistentException;
import by.training.service.UserService;
import by.training.service.servicefactory.CreatorService;
import by.training.service.servicefactory.UserServiceImplFactory;
import by.training.validator.ImgValidator;
import by.training.validator.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePhotoAction extends UserAction {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response)
            throws PersistentException, ServletException,
            IOException, IncorrectFormDataException {
        User user = (User) request.getSession().getAttribute("authorizedUser");
        Validator<Img> imageValidator = new ImgValidator();
        Img image = imageValidator.validate(request);
        if (image != null) {
            creator = new CreatorService();
            UserService service = creator
                    .createService(new UserServiceImplFactory());
            if (service.changePhoto(image.getFilePath(), user.getId())) {
                request.setAttribute("errorEdit",
                        "Successfully changing");
            } else {
                request.setAttribute("errorEdit",
                        "Impossiple to save");
            }
        } else {
            request.setAttribute("errorEdit",
                    "Impossiple to save");
        }

        return new Forward("/edit.jsp", false);
    }

}
