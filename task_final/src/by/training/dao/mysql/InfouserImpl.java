package by.training.dao.mysql;

import by.training.dao.InfouserDao;
import by.training.entity.InfoUser;
import by.training.entity.User;
import by.training.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InfouserImpl extends BaseDaoImpl implements InfouserDao {

    private List<InfoUser> createInfoUserList(ResultSet resultSet) throws SQLException {
        List<InfoUser> infoUsers = new ArrayList<>();
        InfoUser infoUser = null;
        User user = null;
        while(resultSet.next()) {
            infoUser = new InfoUser();
            user = new User();
            user.setId(resultSet.getLong("user_id"));
            infoUser.setUser(user);
            infoUser.setBirthday(resultSet.getDate("birthday"));
            infoUser.setName(resultSet.getString("name"));
            infoUser.setName(resultSet.getString("lastname"));
            infoUser.setName(resultSet.getString("patronymic"));
            infoUser.setAvatar(resultSet.getBinaryStream("avatar"));
            infoUsers.add(infoUser);
        }
        return infoUsers;
    }

    @Override
    public List<InfoUser> readByNameAndLastname(String searchLastname, String searchName) throws PersistentException {
        String sql = "SELECT `user_id`, `birthday`, `name`, `lastname`, `patronymic`, `avatar` FROM `infousers`"
                + " WHERE `lastname` LIKE ? AND `name` LIKE ? ORDER BY `lastname`";
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + searchLastname + "%");
            statement.setString(2, "%" + searchName + "%");
            resultSet = statement.executeQuery();
            return createInfoUserList(resultSet);
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public List<InfoUser> readByLastname(String searchLastname) throws PersistentException {
        String sql = "SELECT `user_id`, `birthday`, `name`, `lastname`, `patronymic`, `avatar` FROM `infousers`"
                + " WHERE `lastname` LIKE ? ORDER BY `lastname`";
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + searchLastname + "%");
            resultSet = statement.executeQuery();
            return createInfoUserList(resultSet);
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public List<InfoUser> read() throws PersistentException {
        String sql = "SELECT `user_id`, `birthday`, `name`, `lastname`, `patronymic`, `avatar` FROM"
                + " `infousers` ORDER BY `lastname`";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            return createInfoUserList(resultSet);
        } catch(SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public int create(InfoUser infoUser) throws PersistentException {
        String sql = "INSERT INTO `infousers` (`user_id`, `birthday`, `name`, `lastname`, `patronymic`, `avatar`)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        ResultSet resultSet = null;
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, infoUser.getUser().getId());
            statement.setDate(2, new Date(infoUser.getBirthday().getTime()));
            statement.setString(3, infoUser.getName());
            statement.setString(4, infoUser.getLastname());
            statement.setString(5, infoUser.getPatronymic());
            statement.setBlob(6, infoUser.getAvatar());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                //logger.error("There is no autoincremented index after trying to add record into table `users`");
                throw new PersistentException();
            }
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) { }
        }
    }

    @Override
    public InfoUser read(long id) throws PersistentException {
            String sql = "SELECT `user_id`, `birthday`, `name`, `lastname`, `patronymic`, `avatar` FROM"
                    + " `infousers` WHERE `user_id` = ?";
            ResultSet resultSet = null;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                resultSet = statement.executeQuery();
                InfoUser infoUser = null;
                User user = null;
                if(resultSet.next()) {
                    infoUser = new InfoUser();
                    user = new User();
                    user.setId(resultSet.getLong("user_id"));
                    infoUser.setUser(user);
                    infoUser.setBirthday(resultSet.getDate("birthday"));
                    infoUser.setName(resultSet.getString("name"));
                    infoUser.setName(resultSet.getString("lastname"));
                    infoUser.setName(resultSet.getString("patronymic"));
                    infoUser.setAvatar(resultSet.getBinaryStream("avatar"));
                }
                return infoUser;
            } catch(SQLException e) {
                throw new PersistentException(e);
            } finally {
                try {
                    resultSet.close();
                } catch(SQLException | NullPointerException e) {}
            }
    }

    @Override
    public void update(InfoUser infoUser) throws PersistentException {
        String sql = "UPDATE `infousers` SET `birthday` = ?, `name` = ?, `lastname` = ?, `patronymic` = ?, `avatar` = ?"
                + " WHERE `user_id` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, new Date(infoUser.getBirthday().getTime()));
            statement.setString(2, infoUser.getName());
            statement.setString(3, infoUser.getLastname());
            statement.setString(4, infoUser.getPatronymic());
            statement.setBlob(5, infoUser.getAvatar());
            statement.setLong(6, infoUser.getUser().getId());
            statement.executeUpdate();
            } catch(SQLException e) {
            throw new PersistentException(e);
        }
    }

    @Override
    public void delete(long id) throws PersistentException {
        String sql = "DELETE FROM `infousers` WHERE `user_id` = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new PersistentException(e);
        }
    }
}
