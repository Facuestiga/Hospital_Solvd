package com.solvd.hospital.model.connections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * IntStram
 * range(int startInclusive, int endExclusive), increment step of 1
 */

import static org.apache.logging.log4j.LogManager.getLogger;

public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));
    int POOL_SIZE = 5;
    private final static Integer EXEC = 6;
    private static int count = 1;
    private final static ConnectionPool cp = ConnectionPool.getInstance();


    public static void main(String[] args) {
        ExecutorService connectionsExecutor = Executors.newFixedThreadPool(EXEC);

        IntStream
                .range(count,EXEC)
                .forEach(e -> {
                    logger.info("A thread is executing a new RunnableConnection");
                    connectionsExecutor.execute(new RunnableConnection(cp, count));

                    count++;
                });
        count = 1;
    }
}
