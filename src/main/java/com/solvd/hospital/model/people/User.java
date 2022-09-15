package com.solvd.hospital.model.people;

//import java.util.logging.LogManager;
//import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class User extends Person {
    private static Logger log = LogManager.getLogger(User.class);
    private long userId;
    private String password;

    public User(String name, String lastName, String email){

    }

    public User(long userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    /*public User(String name, String lastName, int dni, String phone, String address, String pathology, double weight, double height, int age, long userId, String password) {
        super(name, lastName, dni, phone, address, pathology, weight, height, age);
        this.userId = userId;
        this.password = password;
    }*/


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
