package by.training.validator;

import by.training.entity.Entity;

public interface Validator<T extends Entity> {
    boolean validate(T entity);
}
