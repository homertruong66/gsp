package com.gsp.gsp.util;

import com.gsp.gsp.model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    private static Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3306/gspdb";
    private static final String username = "root";
    private static final String password = "Dnt0810";

    public static Connection getCon() {
        return con;
    }

    public DBUtil() {
    }

    public Connection getConnectionUrl() {
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("success");
        } catch (Exception e) {
            System.out.printf(e.getMessage());
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
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery("select * from users");
        ) {
//            System.out.println("thanh cong");

            Admin admin = new Admin();
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                admin.setId(id);
                String firstName = rs.getString("firstname");
                admin.setFirstName(firstName);
                String lastName = rs.getString("lastname");
                admin.setLastName(lastName);
                String email = rs.getString("email");
                admin.setEmail(email);
                String pass = rs.getString("pass");
                admin.setPassword(pass);
                //Token


                //Display values
                System.out.print("ID: " + id);
                System.out.print(", First name: " + firstName);
                System.out.print(", Last name: " + lastName);
                System.out.print(", Email: " + email);
                System.out.print(", Pass: " + pass);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

