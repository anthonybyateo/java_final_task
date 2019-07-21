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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return false;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        Comment comment = (Comment) obj;
        return getId() == comment.getId();
    }

    @Override
    public int hashCode() {
        return (int) getId();
    }

    @Override
    public String toString() {
        return "Comment{" + "user=" + user.toString() +  ", note=" + note
                + ", comment=" + comment + ", dateNote="
                + dateComment.toString() + "}";
    }
}
