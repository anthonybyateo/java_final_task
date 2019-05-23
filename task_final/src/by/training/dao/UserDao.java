package by.training.dao;

import by.training.entity.User;
import by.training.exception.PersistentException;

import java.util.List;

public interface UserDao extends Dao<User> {
    User readByEmailAndPassword(String email, String password);

    User readByLogin(String login);

    User readByEmail(String email);

    List<User> readAllOrderBySub();

    boolean deleteByLogin(String login);

    boolean updateInfouser(User user);

    long createInfouser(User user);

    boolean changePassword(int id, String password);

    List<User> readByLastnameAndName(String searchLastname, String searchName);


}
