package by.training.dao;

import by.training.entity.User;
import by.training.exception.PersistentException;

import java.util.List;

public interface UserDao extends Dao<User> {
    User read(String login, String email, String password) throws PersistentException;

    List<User> read() throws PersistentException;
}
