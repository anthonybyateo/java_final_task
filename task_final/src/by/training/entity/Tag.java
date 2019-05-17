package by.training.entity;

public class Tag extends EntityWithID {
    private String tag;

    public Tag() {
        super();
    }

    public Tag(final long id, final String tag) {
        super(id);
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
