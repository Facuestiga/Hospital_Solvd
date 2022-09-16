package com.solvd.hospital.dao.mySql;

import com.solvd.hospital.model.connections.ConnectionPool;

import java.sql.Connection;

public abstract class AbstractMySqlDAO {
   private static ConnectionPool connectionPool = ConnectionPool.getInstance();
    static  {
       try {
           Class.forName("com.mysql.jdbc.Driver");
           connectionPool = ConnectionPool.getInstance();
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }


   public ConnectionPool getConnectionPool(){
        return connectionPool;
   }

   public void returnConnection(Connection c){
        ConnectionPool.getInstance().returnConnection((com.solvd.hospital.model.connections.Connection) c);
   }
}
