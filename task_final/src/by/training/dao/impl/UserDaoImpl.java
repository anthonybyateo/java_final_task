package by.training.dao.impl;

import by.training.dao.UserDao;
import by.training.entity.Role;
import by.training.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);

    @Override
    public User readByEmailAndPassword(String email, String password) {
        String sql = "SELECT `users`.id, `users`.login, `users`.role, "
                + "`users`.password, `infousers`.birthday, `infousers`.name, "
                + "`infousers`.lastname, `infousers`.avatar FROM `users` "
                + "LEFT JOIN `infousers` ON `users`.id = `infousers`.user_id "
                + "WHERE `users`.email = ? AND `users`.password = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setEmail(email);
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                user.setPassword(password);
                user.setBirthday(resultSet.getDate("birthday"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("lastname"));
                user.setAvatar(resultSet.getBinaryStream("avatar"));
            }
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.error("Statement close error", e);
            }
        }
        return user;
    }

    @Override
    public User readByLogin(String login) {
        String sql = "SELECT `users`.id, `users`.email, `users`.role, "
                + "`users`.password, `infousers`.birthday, `infousers`.name, "
                + "`infousers`.lastname, `infousers`.avatar FROM `users` "
                + "LEFT JOIN `infousers` ON `users`.id = `infousers`.user_id "
                + "WHERE `users`.login = ?";
        ResultSet resultSet = null;
        User user = null;
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setLogin(login);
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                user.setPassword(resultSet.getString("password"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("lastname"));
                user.setAvatar(resultSet.getBinaryStream("avatar"));
            }
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        }
        return user;
    }

    @Override
    public User readByEmail(String email) {
        String sql = "SELECT `users`.id, `users`.login, `users`.role, "
                + "`users`.password, `infousers`.birthday, `infousers`.name, "
                + "`infousers`.lastname, `infousers`.avatar FROM `users` "
                + "LEFT JOIN `infousers` ON `users`.id = `infousers`.user_id "
                + "WHERE `users`.email = ?";
        ResultSet resultSet = null;
        User user = null;
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setEmail(email);
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                user.setPassword(resultSet.getString("password"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("lastname"));
                user.setAvatar(resultSet.getBinaryStream("avatar"));
            }
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        }
        return user;
    }

    @Override
    public List<User> readAllOrderBySub() {
        String sql = "SELECT `users`.id, `users`.login, `users`.email, "
                + "`users`.password, `infousers`.birthday, `infousers`.name, "
                + "`infousers`.lastname, `infousers`.avatar FROM `users` "
                + "LEFT JOIN `infousers` ON `users`.id = `infousers`.user_id "
                + "LEFT JOIN `subscription` ON `users`.id = "
                + "`subscription`.user_id WHERE `subscription`.user_id > 0 "
                + "GROUP BY `subscription`.user_id ORDER BY "
                + "COUNT(`subscriber_id`) DESC";
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("lastname"));
                user.setAvatar(resultSet.getBinaryStream("avatar"));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                LOGGER.error("Statement close error", e);
            }
        }
        return users;
    }

    @Override
    public boolean deleteByLogin(String login) {
        String sql = "DELETE FROM `users` WHERE login = ?";
        try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {
            statement.setString(1, login);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        }
        return false;
    }

    @Override
    public boolean changePassword(int id, String password) {
        String sql = "UPDATE `users` SET password = ? WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setInt(2, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.error("Statement close error", e);
            }
        }
        return false;
    }

    @Override
    public List<User> readByLastnameAndName(String searchLastname, String searchName) {
        String sql = "SELECT `users`.id, `users`.login, `users`.role, "
                + "`users`.password, `infousers`.birthday, `infousers`.name, "
                + "`infousers`.lastname, `infousers`.avatar FROM `users` "
                + "LEFT JOIN `infousers` ON `users`.id = `infousers`.user_id "
                + "WHERE `infousers`.lastname LIKE ? AND `infousers`.name "
                + "LIKE ? ORDER BY `infousers`.lastname";
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + searchLastname + "%");
            statement.setString(2, "%" + searchName + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                user.setEmail(resultSet.getString("Email"));
                user.setPassword(resultSet.getString("password"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("lastname"));
                user.setAvatar(resultSet.getBinaryStream("avatar"));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        }
        return users;
    }

    @Override
    public User read(long id) {
        String sql = "SELECT `users`.id, `users`.email, `users`.login, `users`.role, "
                + "`users`.password, `infousers`.birthday, `infousers`.name, "
                + "`infousers`.lastname, `infousers`.avatar FROM `users` "
                + "LEFT JOIN `infousers` ON `users`.id = `infousers`.user_id "
                + "WHERE `users`.id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setRole(Role.getById(resultSet.getInt("role")));
                user.setPassword(resultSet.getString("password"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("lastname"));
                user.setAvatar(resultSet.getBinaryStream("avatar"));
            }
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                LOGGER.error("Statement close error", e);
            }
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        String sql = "UPDATE `users` SET `login` = ?, `email` = ?, `password` = ?, `role` = ? WHERE `id` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getRole().getId());
            statement.setLong(5, user.getId());
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement close error", e);
        }
        return false;
    }

    @Override
    public boolean updateInfouser(User user) {
        String sql = "UPDATE `infousers` SET `birthday` = ?, `name` = ?, `lastname` = ?"
                + " WHERE `user_id` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, new Date(user.getBirthday().getTime()));
            statement.setString(2, user.getName());
            statement.setString(3, user.getLastname());
            statement.setLong(4, user.getId());
            return statement.executeUpdate() != 0;
        } catch(SQLException e) {
            LOGGER.error("PreparedStatement close error", e);
        }
        return false;
    }

    @Override
    public long create(User user) {
        String sql = "INSERT INTO `users` (`login`, `email`, `password`, `role`) VALUES (?, ?, ?, ?)";
        ResultSet resultSet = null;
        try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getRole().getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getLong(1);
            } else {
                LOGGER.error("There is no autoincremented index after trying to add record into table `users`");
            }
        } catch(SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        }
        return 0;
    }

    @Override
    public boolean createInfouser(User user) {
        String sql = "INSERT INTO `infousers` (`user_id`, `birthday`, `name`, `lastname`)"
                + " VALUES (?, ?, ?, ?)";
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, user.getId());
            statement.setDate(2, new Date(user.getBirthday().getTime()));
            statement.setString(3, user.getName());
            statement.setString(4, user.getLastname());
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement close error", e);

        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM `users` WHERE `id` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
            return false;
        }
    }
}
