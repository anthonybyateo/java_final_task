package by.training.entity;

import  java.sql.Blob;

import java.util.Date;

public class Infouser extends EntityWithoutID {
   private User user;
   private Date birthday;
   private String name;
   private String lastname;
   private String patronymic;
   private Blob avatar;

   public Infouser() {}

    public Infouser(final User user, final Date birthday, final String name, final String lastname,
                    final String patronymic, final Blob avatar) {
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

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }
}
