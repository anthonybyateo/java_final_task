package by.training.service;

import by.training.entity.User;
import by.training.exception.PersistentException;

import java.util.List;

public interface UserService extends Service {
    public List<User> findAll() throws PersistentException;

    public User findByIdentity(long id) throws PersistentException;

    public User findByLoginAndPassword(String login, String password) throws
            PersistentException;

    public User findByEmailAndPassword(String email, String password) throws
            PersistentException;

    public void save(User user) throws PersistentException;

    public void delete(long id) throws PersistentException;
}
