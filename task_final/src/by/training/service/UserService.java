package by.training.service;

import by.training.entity.User;
import by.training.exception.PersistentException;

import java.util.List;

public class UserServiceImpl extends ServiceImpl implements UserService {
    @Override
    public List<User> findAll() throws PersistentException {
        return null;
    }

    @Override
    public User findByIdentity(long id) throws PersistentException {
        return null;
    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws
            PersistentException {
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws
            PersistentException {
        return null;
    }

    @Override
    public void save(User user) throws PersistentException {

    }

    @Override
    public void delete(long id) throws PersistentException {

    }
}
