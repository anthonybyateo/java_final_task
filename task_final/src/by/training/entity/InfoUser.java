package by.training.entity;

import java.io.InputStream;

import java.util.Date;

public class InfoUser extends EntityWithoutID {
   private User user;
   private Date birthday;
   private String name;
   private String lastname;
   private String patronymic;
   private InputStream avatar;

   public InfoUser() {}

    public InfoUser(final User user, final Date birthday, final String name, final String lastname,
                    final String patronymic, final InputStream avatar) {
        this.user = user;
        this.birthday = birthday;
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.avatar = avatar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public InputStream getAvatar() {
        return avatar;
    }

    public void setAvatar(InputStream avatar) {
        this.avatar = avatar;
    }
}
