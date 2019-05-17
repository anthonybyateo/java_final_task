package by.training.dao;

import by.training.exception.PersistentException;

public interface TransactionFactory {
    Transaction createTransaction() throws PersistentException;

    void close();
}
