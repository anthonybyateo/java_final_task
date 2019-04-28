package by.training.entity;

public class Note extends EntityWithID {
    private User user;
    private String note;
    private String tags;

    public Note() {
        super();
        user = new User();
    }

    public Note(int id, User user, String note, String tags) {
        super(id);
        this.user = user;
        this.note = note;
        this.tags = tags;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

}
