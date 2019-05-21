package by.training.service.servicefactory;

import by.training.dao.DaoImplFactory.CreatorDao;
import by.training.exception.PersistentException;
import by.training.service.Service;
import by.training.service.ServiceImpl;

public class CreatorService {
    private CreatorDao creatorDao;

    public CreatorService() throws PersistentException {
        creatorDao = new CreatorDao();
    }

    public <T extends Service> T createService(ServiceImplFactory serviceFactory) {
        ServiceImpl service = serviceFactory.createServiceImpl();
        service.setCreator(creatorDao);
        return (T) service;
    }

    public void close() {
        creatorDao.close();
    }
}
