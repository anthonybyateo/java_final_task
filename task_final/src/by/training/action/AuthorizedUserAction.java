package by.training.action;

import by.training.entity.Role;

import java.util.Arrays;

abstract public class AuthorizedUserAction extends Action {
    public AuthorizedUserAction() {
        getAllowRoles().addAll(Arrays.asList(Role.values()));
    }
}
