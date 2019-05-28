package by.training.service.servicefactory;

import by.training.service.Impl.UserServiceImpl;

public class UserServiceImplFactory extends ServiceImplFactory<UserServiceImpl> {
    @Override
    public UserServiceImpl createServiceImpl() {
        return new UserServiceImpl();
    }
}
