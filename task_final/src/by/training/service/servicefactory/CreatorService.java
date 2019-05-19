package by.training.service.servicefactory;

import by.training.dao.DaoImplFactory.CreatorDao;
import by.training.exception.PersistentException;
import by.training.service.Service;
import by.training.service.ServiceImpl;

public class CreatorService {
/*    private CreatorDao creatorDao;

    public CreatorService(CreatorDao creatorDao) throws PersistentException {
        this.creatorDao = creatorDao;
    }*/

    Service createService(ServiceImplFactory serviceFactory) throws PersistentException {
        CreatorDao creatorDao = new CreatorDao();
        ServiceImpl service;
        service.setCreator(creatorDao);
        return serviceFactory.createServiceImpl();
    }

/*    public void close() {
        creatorDao.close();
    }*/
}
