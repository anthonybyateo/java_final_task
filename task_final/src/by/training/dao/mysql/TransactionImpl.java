package by.training.dao.mysql;

import by.training.dao.Dao;
import by.training.dao.DaoImplFactory.BaseDaoImplFactory;
import by.training.dao.Transaction;
import by.training.exception.PersistentException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionImpl implements Transaction {
    private static Logger logger = Logger.getLogger(TransactionImpl.class);

    private Connection connection;

    public TransactionImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T extends BaseDaoImpl> T createDao(BaseDaoImplFactory factory) {
        BaseDaoImpl dao = factory.createDaoImpl();
        dao.setConnection(connection);
        return (T)dao;
    }

    @Override
    public void commit() throws PersistentException {
        try {
            connection.commit();
        } catch(SQLException e) {
            logger.error("It is impossible to commit transaction", e);
            throw new PersistentException(e);
        }
    }

    @Override
    public void rollback() throws PersistentException {
        try {
            connection.rollback();
        } catch(SQLException e) {
            logger.error("It is impossible to rollback transaction", e);
            throw new PersistentException(e);
        }
    }
}
