package by.training.dao.DaoImplFactory;

import by.training.dao.mysql.BaseDaoImpl;
import by.training.dao.pool.ConnectionPool;
import by.training.exception.PersistentException;

import java.sql.Connection;
import java.sql.SQLException;

public class CreatorDao {
    private Connection connection;

    public <T extends BaseDaoImpl> T createDao(BaseDaoImplFactory factory) throws PersistentException {
        connection = ConnectionPool.getInstance().getConnection();
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
