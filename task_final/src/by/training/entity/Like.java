package by.training.entity;

public class Like extends EntityWithoutID {
    private User user;
    private Note note;
    private byte like;

    public Like() {
        user = new User();
        note = new Note();
    }

    public Like(User user, Note note, byte like) {
        this.user = user;
        this.note = note;
        this.like = like;
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

    public byte getLike() {
        return like;
    }

    public void setLike(byte like) {
        this.like = like;
    }
}
