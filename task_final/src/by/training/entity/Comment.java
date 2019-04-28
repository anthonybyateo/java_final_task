package by.training.entity;

import java.util.Date;

public class Comment extends EntityWithID {
    private User user;
    private Note note;
    private String comment;
    private Date dateComment;

    public Comment() {
        super();
        user = new User();
        note = new Note();
        dateComment = new Date();
    }

    public Comment(int id, User user, Note note, String comment, Date dateComment) {
        super(id);
        this.user = user;
        this.note = note;
        this.comment = comment;
        this.dateComment = dateComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }
}
