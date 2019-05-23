package by.training.service;

import by.training.entity.User;

import java.util.List;

public interface UserService extends Service {
    List<User> findAllOrderBySub();

    List<User> readByLastnameAndName(String searchLastname, String searchName );

    User findById(long id);

    User findByLogin(String login);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    boolean changePassword(int id, String password);

    boolean deleteByLogin(String login);

    long save(User user);

    boolean update(User user);

    boolean delete(long id);
}
