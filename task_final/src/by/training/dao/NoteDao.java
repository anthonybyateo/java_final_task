package by.training.dao;

import by.training.entity.Note;
import by.training.entity.Tag;

import java.util.List;

public interface NoteDao extends Dao<Note>{
    Note readByTag(Tag tag);

    List<Note> readAllOrderByLike();


}
