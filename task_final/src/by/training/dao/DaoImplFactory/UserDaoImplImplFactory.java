package by.training.dao.DaoImplFactory;

import by.training.dao.mysql.UserDaoImpl;

public class UserDaoImplFactory extends BaseDaoFactory<UserDaoImpl>{
    @Override
    public UserDaoImpl createDaoImpl() {
        return new UserDaoImpl();
    }
}
