package by.training.dao.impl;

import by.training.dao.NoteDao;
import by.training.entity.Note;
import by.training.entity.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class NoteDaoImpl extends BaseDaoImpl implements NoteDao {
    private static final Logger LOGGER = LogManager.getLogger(NoteDaoImpl.class);
    @Override
    public Note readByTag(Tag tag) {
        return null;
    }

    @Override
    public List<Note> readAllOrderByLike() {
        return null;
    }

    @Override
    public long create(Note note) {
        String sql = "INSERT INTO `notes` (`user_id`, `note`, `date_notes`) "
                + "VALUES (?, ?, ?)";
        ResultSet resultSet = null;
        try(PreparedStatement statement = connection
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, note.getUser().getId());
            statement.setString(2, note.getNote());
            statement.setDate(3, new Date(note.getDateNote().getTime()));
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getLong(1);
            } else {
                LOGGER.error("There is no autoincremented index after "
                        + "trying to add record into table `users`");
            }
        } catch(SQLException e) {
            LOGGER.error("Create note error", e);
        }
        return 0;
    }

    @Override
    public Note read(long id) {
        return null;
    }

    @Override
    public boolean update(Note entity) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
