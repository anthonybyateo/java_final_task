package by.training.service.servicefactory;

import by.training.service.Impl.ServiceImpl;

abstract public class ServiceImplFactory<T extends ServiceImpl> {
    public abstract T createServiceImpl();
}
