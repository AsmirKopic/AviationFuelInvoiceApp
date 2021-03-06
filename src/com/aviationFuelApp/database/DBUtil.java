package com.aviationFuelApp.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static final String DB_NAME = "aviationFuelService.db";
  //public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\HP\\Desktop\\Java Programms\\AviationFuel\\" + DB_NAME;
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\asmir\\Desktop\\AviationFuelTEST\\" + DB_NAME;

    /**
     * This is static method that creates a connection to the database.
     * @return connection object (conn).
     */
    public static Connection getConnection() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * This is static method for close open connection
     * @param conn Connection object which needs to be closed
     */
    public static void closeConnection(Connection conn) {

        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
