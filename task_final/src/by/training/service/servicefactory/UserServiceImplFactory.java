package by.training.service.servicefactory;

import by.training.service.UserService;

public class UserServiceImplFactory extends ServiceImplFactory<UserService> {
    @Override
    public UserService createServiceImpl() {
        return new UserService();
    }
}
