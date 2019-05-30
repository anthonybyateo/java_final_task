package by.training.action.admin;

import by.training.action.Action;
import by.training.entity.Role;

abstract public class AdminAction extends Action {
    public AdminAction() {
        getAllowRoles().add(Role.ADMINISTRATOR);
    }
}
