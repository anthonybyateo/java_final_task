package by.training.service.Impl;

import by.training.dao.DaoImplFactory.CreatorDao;
import by.training.service.Service;

abstract public class ServiceImpl implements Service {
    protected CreatorDao creator;

    public void setCreator(CreatorDao creator) {
        this.creator = creator;
    }
}
