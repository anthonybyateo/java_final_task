package by.training.dao.DaoImplFactory;

import by.training.dao.impl.BaseDaoImpl;
import by.training.dao.pool.ConnectionPool;
import by.training.exception.PersistentException;

import java.sql.Connection;
import java.sql.SQLException;

public class CreatorDao {
    private Connection connection;

    public CreatorDao() throws PersistentException {
        connection = ConnectionPool.getInstance().getConnection();
    }

    public <T extends BaseDaoImpl> T createDao(BaseDaoImplFactory factory) {
        BaseDaoImpl dao = factory.createDaoImpl();
        dao.setConnection(connection);
        return (T)dao;
    }

    public void close() {
        try {
            connection.close();
        } catch(SQLException e) {}
    }
}
