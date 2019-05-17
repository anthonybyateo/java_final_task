package by.training.dao.DaoImplFactory;

import by.training.dao.mysql.UserDaoImpl;

public class UserDaoImplImplFactory extends BaseDaoImplFactory<UserDaoImpl> {
    @Override
    public UserDaoImpl createDaoImpl() {
        return new UserDaoImpl();
    }
}
