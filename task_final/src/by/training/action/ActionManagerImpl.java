package by.training.action;

import by.training.exception.IncorrectFormDataException;
import by.training.exception.PersistentException;
import by.training.service.servicefactory.CreatorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActionManagerImpl implements ActionManager {
    private CreatorService creator;

    public ActionManagerImpl(CreatorService creator) {
        this.creator = creator;
    }

    @Override
    public Action.Forward execute(Action action, HttpServletRequest request, HttpServletResponse response) throws
            PersistentException, ServletException, IOException, IncorrectFormDataException {
        action.setFactory(creator);
        return action.exec(request, response);
    }

    @Override
    public void close() {
        creator.close();
    }
}
