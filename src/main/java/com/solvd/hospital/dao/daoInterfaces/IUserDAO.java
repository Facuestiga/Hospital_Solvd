package com.solvd.hospital.dao.daoInterfaces;

import com.solvd.hospital.model.people.User;

import java.util.List;

public interface IUserDAO extends IBaseDAO<User>{
    List<User> getAllUsers();
}
