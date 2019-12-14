package com.gsp.gsp.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    // JDBC driver name and database URL
        /*static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/gspdb";

        //  Database credentials
        static final String USER = "root";
        static final String PASS = "123456";*/
    public static void main(String[] args) {

    }

    public static Connection connection()throws SQLException,
                ClassNotFoundException {
            String DB_URL = "jdbc:mysql://localhost/gspdb";
            String DB_NAME ="gspdb";
            String USER = "root";
            String PASS = "123456";
            return connection(DB_URL,DB_NAME,USER,PASS);
        }
        public static Connection connection(String DB_URL, String DB_NAME, String USER, String PASS)throws SQLException,
                    ClassNotFoundException {
                //STEP 2: Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                //STEP 3: Open a connection
                System.out.println("Connecting to a selected database...");
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connected database successfully...");
                return conn;
        }

}

