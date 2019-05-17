package by.training.service;

import by.training.dao.DaoImplFactory.BaseDaoImplFactory;
import by.training.dao.DaoImplFactory.UserDaoImplImplFactory;
import by.training.dao.UserDao;
import by.training.dao.mysql.UserDaoImpl;
import by.training.entity.User;
import by.training.exception.PersistentException;

import java.util.List;

public class UserService extends ServiceImpl {
    public List<User> findAll() throws PersistentException {
        UserDao dao = transaction.createDao( new UserDaoImplImplFactory());
        return dao.read();
    }

    public User findByIdentity(long id) throws PersistentException {
        return null;
    }

    public User findByLoginAndPassword(String login, String password) throws
            PersistentException {
        return null;
    }

    public User findByEmailAndPassword(String email, String password) throws
            PersistentException {
        return null;
    }

    public void save(User user) throws PersistentException {

    }

    public void delete(long id) throws PersistentException {

    }
}
