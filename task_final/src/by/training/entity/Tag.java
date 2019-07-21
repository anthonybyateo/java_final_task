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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return false;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        Tag tag = (Tag) obj;
        return getId() == tag.getId();
    }

    @Override
    public int hashCode() {
        return (int)getId();
    }

    @Override
    public String toString() {
        return "Tag{" + "id='" + getId() + ", tag='" + tag + '}';
    }
}
