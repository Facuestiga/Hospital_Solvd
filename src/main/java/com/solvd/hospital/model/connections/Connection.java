package com.solvd.hospital.model.connections;
import java.util.logging.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;

public class Connection {

    private static final Logger logger = Logger.getLogger(String.valueOf(Connection.class));
    private int id;

    public Connection(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void doSomething() throws InterruptedException {
        logger.info("Connection " + id + " is executing");
        wait(2000);
    }

    public void closeConnection() throws InterruptedException {
        logger.info("Releasing connection");
        ConnectionPool
                .getInstance()
                .freeConnection(this);
    }
}