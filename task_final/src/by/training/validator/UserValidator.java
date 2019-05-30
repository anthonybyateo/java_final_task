package by.training.validator;

import by.training.entity.Entity;
import by.training.entity.User;

public class UserValidator implements Validator<User> {
    private static final int MIN_NAME = 3;
    private static final int MIN_PASS = 6;
    private static final int MAX_LOGIN = 254;
    private static final String EMAIL
            = "([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6})";
    private static final int MAX_EMAIL = 32;
    private static final int MAX_NAME_AND_LASTNAME = 40;

    @Override
    public boolean validate(final User user) {
        return user.getLogin() != null && user.getLogin().length() >= MIN_NAME
                && user.getLogin().length() <= MAX_LOGIN
                && user.getEmail().matches(EMAIL)
                && user.getEmail().length() <= MAX_EMAIL
                && user.getName() != null && user.getName().length() >= MIN_NAME
                && user.getName().length() <= MAX_NAME_AND_LASTNAME
                && user.getLastname() != null && user.getLastname().length()
                >= MIN_NAME
                && user.getLastname().length() <= MAX_NAME_AND_LASTNAME
                && user.getPassword() != null && user.getPassword().length()
                >= MIN_PASS;
    }

    public boolean validateChangePassword(final String newPassword,
                                          final String ConfNewPassword) {
        return newPassword != null && newPassword.equals(ConfNewPassword);
    }
}
