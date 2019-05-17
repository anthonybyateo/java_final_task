package by.training.service;

import java.security.MessageDigest;
import by.training.dao.DaoImplFactory.UserDaoImplImplFactory;
import by.training.dao.UserDao;
import by.training.entity.User;
import by.training.exception.PersistentException;

import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.List;

public class UserServiceImp extends ServiceImpl implements UserService{
    @Override
    public List<User> findAll() throws PersistentException {
        UserDao dao = creator.createDao( new UserDaoImplImplFactory());
        return dao.read();
    }

    @Override
    public User findByIdentity(long id) throws PersistentException {
        UserDao dao = creator.createDao( new UserDaoImplImplFactory());
        return dao.read(id);
    }

    //TODO unit to method
    @Override
    public User findByLoginAndPassword(String login, String password) throws
            PersistentException {
        UserDao dao = creator.createDao( new UserDaoImplImplFactory());
        return dao.readByLogin(login, md5(password));
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws
            PersistentException {
        UserDao dao = creator.createDao( new UserDaoImplImplFactory());
        return dao.readByLogin(email, md5(password));
    }

    @Override
    public void save(User user) throws PersistentException {
        UserDao dao = creator.createDao( new UserDaoImplImplFactory());
            if(user.getPassword() != null) {
                user.setPassword(md5(user.getPassword()));
            } else {
                User oldUser = dao.read(user.getId());
                user.setPassword(oldUser.getPassword());
            }
            dao.update(user);
    }

    @Override
    public void delete(long id) throws PersistentException {
        UserDao dao = creator.createDao( new UserDaoImplImplFactory());
        dao.delete(id);
    }

    private String md5(String string) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("md5");
            digest.reset();
            digest.update(string.getBytes());
            byte hash[] = digest.digest();
            Formatter formatter = new Formatter();
            for(int i = 0; i < hash.length; i++) {
                formatter.format("%02X", hash[i]);
            }
            String md5summ = formatter.toString();
            formatter.close();
            return md5summ;
        } catch(NoSuchAlgorithmException e) {
            return null;
        }
    }

}
