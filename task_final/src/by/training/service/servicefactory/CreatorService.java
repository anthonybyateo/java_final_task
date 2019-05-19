package by.training.service.servicefactory;

import by.training.dao.DaoImplFactory.CreatorDao;
import by.training.service.Service;
import by.training.service.ServiceImpl;

public class CreatorService {
    private CreatorDao creatorDao;

    public CreatorService(CreatorDao creatorDao) {
        this.creatorDao = creatorDao;
    }

    Service createService(ServiceImplFactory serviceFactory) {
        ServiceImpl service = serviceFactory.createServiceImpl();
        service.setCreator(creatorDao);
        return service;
    }

    public void close() {
        creatorDao.close();
    }
}
