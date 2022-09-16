package com.solvd.hospital.dao.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyJDBC {
    private static final Logger logger = LogManager.getLogger(MyJDBC.class);
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/model_hospital_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "root";

    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASS);
        }
        return dataSource;
    }


    /**
     * return a data source to connected to the data base
     * @return  dataSource
     * @throws SQLException exception
     */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    /**
     * Close Result set
     * @param rs
     */
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    /**
     * Close Prepared Statement
     * @param ps
     */
    public static void close(PreparedStatement ps){
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    /**
     * Close the connection
     * @param conn
     */
    public static void close(java.sql.Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }
}
