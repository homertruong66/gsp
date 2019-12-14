package com.gsp.gsp.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectToDB {
    private static Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3306/gspdb";
//    private static final String serverName = "DESKTOP-43TDTOS";
//    private static final String portNumber = "3306";
//    private static final String databaseName = "gspdb";
    private static final String username = "root";
    private static final String password = "Dnt0810";

    public connectToDB() { }

    public static String getConnectionUrl() {
//        return url + serverName +  ":" +  portNumber + "/" + databaseName + "; username= " + username
//                + "; password = " + password;
            return url + username + password;
    }

    public static Connection getConnection() throws Exception {
        try {
//            con = DriverManager.getConnection(getConnectionUrl());
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            con = null;
            throw new Exception(e.getMessage());
        }
        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
            con = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Connection con =
                    DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            System.out.println("thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
