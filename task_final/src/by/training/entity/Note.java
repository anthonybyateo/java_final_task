package by.training.entity;

import java.util.Date;

public class Note extends EntityWithID {
    private User user;
    private String note;
    private Date dateNote;

    public Note() {
        super();
        user = new User();
        dateNote = new Date();
    }

    public Note(int id, User user, String note, Date dateNote) {
        super(id);
        this.user = user;
        this.note = note;
        this.dateNote = dateNote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }
}