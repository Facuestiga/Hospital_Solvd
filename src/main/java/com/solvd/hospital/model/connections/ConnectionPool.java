package com.solvd.hospital.model.connections;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import static org.apache.logging.log4j.LogManager.getLogger;


public class ConnectionPool {
    private static final Logger logger = getLogger(ConnectionPool.class);
    private static volatile ConnectionPool instance;
    private static final int MAX_CONNECTION_SIZE = 5;
    private static LinkedBlockingQueue<Connection> connections;
    private static int connectionCount = 0;

    private ConnectionPool(){
        connections = new LinkedBlockingQueue<>(MAX_CONNECTION_SIZE);
    }

    /**
     * Singleton Pattern to instance a connectionPool
     * @return instance of connection pool
     */
    //Singleton Pattern
    public static ConnectionPool getInstance(){
        ConnectionPool result;
        if (instance == null){
            synchronized (ConnectionPool.class){
                result = instance;
                if(result == null){
                    instance = new ConnectionPool();
                    logger.info("ConnectionPool initialization started");
                }
            }
        }
        logger.info("Returning ConnectionPool");
        return instance;
    }

    private synchronized void newConnection(){
        logger.info("A new connection is being created with a number of: " + connectionCount);
        connections.add(new Connection(connectionCount));
        connectionCount++;
    }

    public Connection getConnection() throws InterruptedException {
        if (connectionCount < MAX_CONNECTION_SIZE){
            newConnection();
        }
        return connections.take(); // Retrieves and removes the head of this queue

    }

    public void returnConnection(Connection conn){
        connections.add(conn); //Inserts the specified element at the tail of this queue - al final de la cola
                                //returning true upon success and false if this queue is full.
    }
    public void freeConnection(Connection connection) throws InterruptedException {
        connections.put(connection); //Inserts the specified element at the tail of this queue
    }
    public void backConnection(Connection connection) throws InterruptedException {
        connections.offer(connection);

    }

    /**
     * Close all connections
     */
    public void closeConnections(){
        connections.forEach(conn -> {
            try {
                conn.closeConnection();
            } catch (InterruptedException exception) {
                logger.warn("an error happened when the connection was closing", exception);
            }
        });
        connections = new LinkedBlockingQueue<Connection>(MAX_CONNECTION_SIZE);
        connectionCount = 0;
    }

}
