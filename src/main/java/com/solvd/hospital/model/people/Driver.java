package com.solvd.hospital.model.people;

public class Driver extends User {



    public Driver(String name, String lastName, String email) {
        super(name, lastName, email);
    }

    public Driver(long userId, String password) {
        super(userId, password);
    }
}
