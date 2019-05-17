package by.training.dao.DaoImplFactory;

import by.training.dao.mysql.BaseDaoImpl;

abstract public class BaseDaoFactory<T extends BaseDaoImpl> {
    public abstract T createDaoImpl();
}
