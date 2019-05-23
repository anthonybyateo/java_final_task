package by.training.dao;

import by.training.entity.Entity;
import by.training.exception.PersistentException;

public interface Dao<Type extends Entity> {
    long create(Type entity);

    Type read(long id);

    boolean update(Type entity);

    boolean delete(long id);

}
