package by.training.service.servicefactory;

import by.training.dao.DaoImplFactory.CreatorDao;
import by.training.exception.PersistentException;
import by.training.service.Service;

public class CreatorService {
    Service createService(ServiceImplFactory serviceFactory) throws PersistentException {
        return serviceFactory.createServiceImpl();
    }
}
