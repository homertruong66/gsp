package com.gsp.gsp.util;

import com.gsp.gsp.models.User;

import java.sql.*;

public class DBUtil {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/gspdb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    public static String get(String sql){

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            User user = new User();
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                user.setId(id);
                String firstName = rs.getString("firstname");
                user.setFirstName(firstName);
                String lastName = rs.getString("lastname");
                user.setLastName(lastName);
                String email = rs.getString("email");
                user.setEmail(email);
                String pass = rs.getString("pass");
                user.setPass(pass);
                byte role = rs.getByte("role");
                user.setRole(role);
                //Token

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", First name: " + firstName);
                System.out.print(", Last name: " + lastName);
                System.out.print(", Email: " + email);
                System.out.print(", Pass: " + pass);
                System.out.print(", Role: " + role);
                System.out.println();
            }

            if (user.getId()!=-1) {
                // Todo: generalize token and save to database, add to user field
                // Create util package (class DBUtil get(sql query), create(sql query), update(sql query), delete(sql query))
                return user.toString();
            }
            rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return "";
    }
}
