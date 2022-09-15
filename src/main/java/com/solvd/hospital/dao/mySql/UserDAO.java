package com.solvd.hospital.dao.mySql;

import com.solvd.hospital.dao.daoInterfaces.IUserDAO;
import com.solvd.hospital.model.people.User;

import java.util.List;

public class UserDAO extends AbstractMySqlDAO implements IUserDAO {

    @Override
    public void create(User u) {

    }

    @Override
    public User getById(long id) {


        return null;
    }

    @Override
    public void update(User object) {

    }


    @Override
    public void delete(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
