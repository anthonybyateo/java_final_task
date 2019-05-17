package by.training.dao;

import by.training.entity.Entity;
import by.training.exception.PersistentException;

public interface Dao<Type extends Entity> {
    int create(Type entity) throws PersistentException;

    Type read(long id) throws PersistentException;

    void update(Type entity) throws PersistentException;

    void delete(long id) throws PersistentException;

}
