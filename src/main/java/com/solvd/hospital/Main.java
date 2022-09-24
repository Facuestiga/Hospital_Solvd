package com.solvd.hospital;
import com.solvd.hospital.model.people.Patient;
import com.solvd.hospital.model.people.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {


    private static Scanner scn = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        int option;
        logger.info("Welcome to Solvd Hospital");
        Person patient1 = new Patient();

        do{
            printMenu();
            option = scn.nextInt();
        }while(option != 5);
    }

    public static void printMenu() {
        logger.info("Please enter an option");
        logger.info("1.CREATE");
        logger.info("2.READ");
        logger.info("3.UPDATE");
        logger.info("4.DELETE");
        logger.info("5.Exit");
        logger.info("Choose an option: ");
    }
}
