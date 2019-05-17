package by.training.dao;

import by.training.dao.DaoImplFactory.BaseDaoImplFactory;
import by.training.dao.mysql.BaseDaoImpl;
import by.training.exception.PersistentException;

public interface Transaction {
    <T extends BaseDaoImpl> T createDao(BaseDaoImplFactory factory) throws PersistentException;

    void commit() throws PersistentException;

    void rollback() throws PersistentException;
}
