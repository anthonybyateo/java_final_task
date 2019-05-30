package by.training.action;

import by.training.exception.IncorrectFormDataException;
import by.training.exception.PersistentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActionManager {
    Action.Forward execute(Action action, HttpServletRequest request, HttpServletResponse response)
            throws PersistentException, ServletException, IOException, IncorrectFormDataException;

    void close();
}
