package com.solvd.hospital.model.connections;

import java.util.logging.Logger;

public class RunnableConnection implements Runnable{
    private static final Logger logger = Logger.getLogger(String.valueOf(RunnableConnection.class));
    private final ConnectionPool cp;
    private final int id;

    public RunnableConnection(ConnectionPool cp, int id) {
        this.cp = cp;
        this.id = id;
    }

    @Override
    public void run() {

        Connection conn = null;
        try {
            logger.info(this.toString() + " is taking a connection");
            conn = cp.getConnection();

            conn.doSomething();

            logger.info(this.toString() + " is placing back the connection " + conn.getId());
            cp.backConnection(conn);

        } catch (InterruptedException e) {
            logger.info(this.toString() + " Failed to get a connection: " + e);
        }
    }
    public int getId() {
        return id;
    }

    public ConnectionPool getCp() {
        return cp;
    }

    @Override
    public String toString(){
        return "RunnableConnection " + id;
    }


}
