package by.training.dao.DaoImplFactory;

import by.training.dao.mysql.BaseDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class CreatorDao {
    private Connection connection;

    public CreatorDao(Connection connection) {
        this.connection = connection;
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
