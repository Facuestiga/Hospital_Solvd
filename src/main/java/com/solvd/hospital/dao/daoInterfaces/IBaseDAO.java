package com.solvd.hospital.dao.daoInterfaces;

import java.sql.SQLException;

public interface IBaseDAO <T> {
    void create (T object);

    T getById (long id) throws SQLException;

    void update (T object);

    void delete (long id);


}
