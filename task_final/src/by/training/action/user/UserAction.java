package by.training.action.user;

import by.training.action.Action;
import by.training.entity.Role;

abstract public class UserAction extends Action{
    public UserAction() {
        getAllowRoles().add(Role.USER);
    }
}
