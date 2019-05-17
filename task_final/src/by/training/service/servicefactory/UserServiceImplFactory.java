package by.training.service.servicefactory;

import by.training.service.UserServiceImp;

public class UserServiceImplFactory extends ServiceImplFactory<UserServiceImp> {
    @Override
    public UserServiceImp createServiceImpl() {
        return new UserServiceImp();
    }
}
