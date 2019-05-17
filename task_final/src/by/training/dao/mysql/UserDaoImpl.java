package by.training.dao.mysql;

import by.training.dao.UserDao;
import by.training.entity.Role;
import by.training.entity.User;
import by.training.exception.PersistentException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public User readByEmail(String email, String password) throws PersistentException {
        String sql = "SELECT `id`, `login`, `role` FROM `users` WHERE `email` = ? AND `password` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(email);
                user.setLogin(resultSet.getString("login"));
                user.setPassword(password);
                user.setRole(Role.getById(resultSet.getInt("role")));
            }
            return user;
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public User readByLogin(String login, String password) throws PersistentException {
        String sql = "SELECT `id`, `email`, `role` FROM `users` WHERE `login` = ? AND `password` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(Role.getById(resultSet.getInt("role")));
            }
            return user;
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public List<User> read() throws PersistentException {
        String sql = "SELECT `id`, `login`, `email`, `password`, `role` FROM `users` ORDER BY `login`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            User user = null;
            while(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setLogin(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                users.add(user);
            }
            return users;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public int create(User user) throws PersistentException {
        String sql = "INSERT INTO `users` (`login`, `email`, `password`, `role`) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole().getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                //logger.error("There is no autoincremented index after trying to add record into table `users`");
                throw new PersistentException();
            }
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public User read(long id) throws PersistentException {
        String sql = "SELECT `login`, `email`, `password`, `role` FROM `users` WHERE `id` = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            User user = null;
            if(resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.getById(resultSet.getInt("role")));
            }
            return user;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void update(User user) throws PersistentException {
        String sql = "UPDATE `users` SET `login` = ?, `email` = ?, `password` = ?, `role` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole().getId());
            statement.setLong(5, user.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void delete(long id) throws PersistentException {
        String sql = "DELETE FROM `users` WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }
}
