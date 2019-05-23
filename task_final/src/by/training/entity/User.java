package by.training.entity;

import java.io.InputStream;
import java.util.Date;

public class User extends EntityWithID {
    private String login;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private Role role;
    private Date birthday;
    private InputStream avatar;

    public User() {
        birthday = new Date();
    }

    public User(long id, String login, String email, String password,
                String name, String lastname, Role role, Date birthday,
                InputStream avatar) {
        super(id);
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
        this.birthday = birthday;
        this.avatar = avatar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public InputStream getAvatar() {
        return avatar;
    }

    public void setAvatar(InputStream avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role=" + role +
                ", birthday=" + birthday +
                ", avatar=" + avatar +
                '}';
    }
}
