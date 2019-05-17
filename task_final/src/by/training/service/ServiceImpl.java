package by.training.service;

import by.training.dao.DaoImplFactory.CreatorDao;

abstract public class ServiceImpl implements Service {
    protected CreatorDao creator;

    public void setCreator(CreatorDao creator) {
        this.creator = creator;
    }
}
