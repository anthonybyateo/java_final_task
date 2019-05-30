package by.training.validator;

import by.training.entity.Entity;
import by.training.exception.IncorrectFormDataException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface Validator<T extends Entity> {
    T validate(HttpServletRequest request) throws IOException, ServletException,
            IncorrectFormDataException;
}
