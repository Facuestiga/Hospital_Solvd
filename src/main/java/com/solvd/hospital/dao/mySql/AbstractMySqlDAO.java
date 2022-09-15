package com.solvd.hospital.dao.mySql;

public abstract class AbstractMySqlDAO {
   static  {
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }
}
