package com.solvd.hospital.model;

import com.solvd.hospital.model.people.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class MainTest {

    private static Logger logMain = LogManager.getLogger(MainTest.class);
    private static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {


        User u = new User("John", "Smith", "john@email.com");

        logMain.info("Hello User! " + u.getName() + u.getLastName());


        logMain.info(u.toString());


    }

}
