package by.training.dao.DaoImplFactory;

import by.training.dao.impl.BaseDaoImpl;

abstract public class BaseDaoImplFactory<T extends BaseDaoImpl> {
    public abstract T createDaoImpl();
}
