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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return false;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        Note note = (Note) obj;
        return getId() == note.getId();
    }

    @Override
    public int hashCode() {
        return (int)getId();
    }

    @Override
    public String toString() {
        return "Note{" + "id='" + getId() + ", user='" + user.toString() +  ", note='" + note
                + ", dateNote='" + dateNote.toString() + '}';
    }
}