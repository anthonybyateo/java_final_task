package by.training.dao.mysql;

import by.training.dao.Transaction;
import by.training.dao.TransactionFactory;
import by.training.exception.PersistentException;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionFactoryImpl implements TransactionFactory {
    private static Logger logger = Logger.getLogger(TransactionFactoryImpl.class);
    private Connection connection;

    public TransactionFactoryImpl() throws PersistentException {
        connection = dao.pool.ConnectionPool.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
        } catch(SQLException e) {
            logger.error("It is impossible to turn off autocommiting for database connection", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public Transaction createTransaction() throws PersistentException {
        return new TransactionImpl(connection);
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch(SQLException e) {}
    }
}
