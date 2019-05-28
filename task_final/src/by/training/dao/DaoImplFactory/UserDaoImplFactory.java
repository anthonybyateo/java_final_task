package by.training.dao.DaoImplFactory;

import by.training.dao.impl.UserDaoImpl;

public class UserDaoImplFactory extends BaseDaoImplFactory<UserDaoImpl> {
    @Override
    public UserDaoImpl createDaoImpl() {
        return new UserDaoImpl();
    }
}
