package by.training.service.servicefactory;

import by.training.service.ServiceImpl;

abstract public class ServiceImplFactory<T extends ServiceImpl> {
    public abstract T createServiceImpl();
}
