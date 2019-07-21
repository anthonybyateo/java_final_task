package by.training.validator;

import by.training.exception.IncorrectFormDataException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

public interface Validator<T extends Serializable> {
    T validate(HttpServletRequest request) throws IOException, ServletException,
            IncorrectFormDataException;
}
