package by.training.service.servicefactory;

import by.training.dao.Transaction;
import by.training.dao.TransactionFactory;
import by.training.exception.PersistentException;
import by.training.service.Service;

import by.training.service.ServiceImpl;
import org.apache.log4j.Logger;

public class ServiceFactoryImpl {
    private static Logger logger = Logger.getLogger(ServiceFactoryImpl.class);

    private TransactionFactory factory;

    public ServiceFactoryImpl(TransactionFactory factory) throws PersistentException {
        this.factory = factory;
    }

    <T extends Service> T createService(ServiceImplFactory serviceFactory) throws PersistentException {
        Transaction transaction = factory.createTransaction();
        ServiceImpl service = serviceFactory.createServiceImpl();
        service.setTransaction(transaction);
        return (T) service;
    }

    void close() {
        factory.close();
    }
}
