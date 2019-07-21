package by.training.dao;

import by.training.entity.User;

import java.util.List;

public interface UserDao extends Dao<User> {
    User readByEmailAndPassword(String email, String password);

    User readByLogin(String login);

    User readByEmail(String email);

    List<User> readAllOrderBySub();

    boolean deleteByLogin(String login);

    boolean updateInfouser(User user);

    boolean createInfouser(User user);

    boolean changePassword(long id, String password);

    List<User> readByLastnameAndName(String searchLastname, String searchName);

    boolean changePhoto(String filePath, long id);
}
