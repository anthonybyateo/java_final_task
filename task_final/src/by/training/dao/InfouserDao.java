package by.training.dao;

import by.training.entity.InfoUser;
import by.training.exception.PersistentException;

import java.util.List;

public interface InfouserDao extends Dao<InfoUser> {

    List<InfoUser> readByNameAndLastname(String searchLastname, String searchName) throws PersistentException;

    List<InfoUser> readByLastname(String searchLastname) throws PersistentException;

    List<InfoUser> read() throws PersistentException;

}
