package com.solvd.hospital.dao.daoInterfaces;

import com.solvd.hospital.model.exception.DAOException;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO <T, K> {
    void create (T object) throws SQLException;

    T getById (K id) throws SQLException;

    void update (T object) throws DAOException,ConnectException, SQLException;

    void delete (K id) throws SQLException;

    List<T> listAll () throws SQLException;


}
