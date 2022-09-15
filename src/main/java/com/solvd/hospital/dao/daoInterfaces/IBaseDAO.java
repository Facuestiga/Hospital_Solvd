package com.solvd.hospital.dao.daoInterfaces;

public interface IBaseDAO <T> {
    void create (T object);

    T getById (long id);

    void update (T object);

    void delete (long id);


}
