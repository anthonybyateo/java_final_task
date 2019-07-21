package by.training.entity;

public class Like implements Entity {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return false; }
        if (obj == null || getClass() != obj.getClass()) { return false; }
        Like like = (Like) obj;
        if(this.hashCode() != like.hashCode()) { return false; }
        return (user == like.getUser()
                || (user != null && user.equals(like.getUser())))
                && (note == like.getNote()
                || (note != null && note.equals(like.getNote())))
                && this.like == like.getLike();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return (int)( prime  + ((user == null) ? 0 : user.hashCode())
                + ((note == null) ? 0 : note.hashCode())
                + getLike());
    }

    @Override
    public String toString() {
        return "Like{" + "user='" + user.toString() + ", note='"
                + note.toString()
                + ", like='" + getLike() + '}';
    }
}
