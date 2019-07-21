package by.training.dao;

import java.io.Serializable;

public interface Dao<Type extends Serializable> {
    long create(Type entity);

    Type read(long id);

    boolean update(Type entity);

    boolean delete(long id);

}
