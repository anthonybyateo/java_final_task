package by.training.entity;

public class NoteTag extends EntityWithoutID {
    private Tag tag;
    private Note note;

    public NoteTag() {
        this.tag = new Tag();
        this.note = new Note();
    }

    public NoteTag(Tag tag, Note note) {
        this.tag = tag;
        this.note = note;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
