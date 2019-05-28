package by.training.service.Impl;

import java.security.MessageDigest;
import by.training.dao.DaoImplFactory.UserDaoImplFactory;
import by.training.dao.UserDao;
import by.training.entity.User;
import by.training.service.UserService;

import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.List;

public class UserServiceImpl extends ServiceImpl implements UserService {
    @Override
    public List<User> findAllOrderBySub() {
        UserDao dao = creator.createDao(new UserDaoImplFactory());
        return dao.readAllOrderBySub();
    }

    @Override
    public List<User> readByLastnameAndName(String searchLastname, String searchName) {
        UserDao dao = creator.createDao(new UserDaoImplFactory());
        return dao.readByLastnameAndName(searchLastname, searchName);
    }

    @Override
    public User findById(long id) {
        UserDao dao = creator.createDao(new UserDaoImplFactory());
        return dao.read(id);
    }

    @Override
    public User findByLogin(String login) {
        UserDao dao = creator.createDao(new UserDaoImplFactory());
        return dao.readByLogin(login);
    }

    @Override
    public User findByEmail(String email) {
        UserDao dao = creator.createDao( new UserDaoImplFactory());
        return dao.readByEmail(email);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        UserDao dao = creator.createDao( new UserDaoImplFactory());
        return dao.readByEmailAndPassword(email, md5(password));
    }

    @Override
    public boolean changePassword(int id, String password) {
        if (password != null) {
            UserDao dao = creator.createDao( new UserDaoImplFactory());
            return dao.changePassword(id, password);
        }
        return false;
    }

    @Override
    public boolean deleteByLogin(String login) {
        UserDao dao = creator.createDao( new UserDaoImplFactory());
        return dao.deleteByLogin(login);
    }

    @Override
    public long save(User user) {
        if (user != null) {
            UserDao dao = creator.createDao(new UserDaoImplFactory());
            if (user.getPassword() != null) {
                user.setPassword(md5(user.getPassword()));
            }
            long id = dao.create(user);
            user.setId(id);
            if (id != 0 && dao.createInfouser(user)) {
                return id;
            }
        }
       return 0;
    }

    @Override
    public boolean update(User user) {
        if (user != null) {
            UserDao dao = creator.createDao(new UserDaoImplFactory());
            if (dao.update(user) && dao.updateInfouser(user)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        UserDao dao = creator.createDao( new UserDaoImplFactory());
        return dao.delete(id);
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
