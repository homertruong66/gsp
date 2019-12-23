/*
package com.gsp.gsp.util;

import com.gsp.gsp.model.User;

import java.sql.*;
import java.util.UUID;

public class DBUtil {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/gsp";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "admin";

    public static User getUser(String sql){
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            User user = new User();
            while (rs.next()) {
                //Retrieve by column name
                String id = rs.getString("id");
                user.setId(id);
                String firstName = rs.getString("first_name");
                user.setFirstName(firstName);
                String lastName = rs.getString("last_name");
                user.setLastName(lastName);
                String email = rs.getString("email");
                user.setEmail(email);
                String password = rs.getString("password");
                user.setPassword(password);
                String role = rs.getString("role");
                user.setRole(role);
                String token = rs.getString("token");
                user.setToken(token);
            }

            if (user.getId() != null) {
                String token = UUID.randomUUID().toString();
                String updateTokenSql = "UPDATE users u " +
                                        "SET u.token = '" + token + "' " +
                                        "WHERE u.id = '" + user.getId() + "'";
                updateToken(updateTokenSql);
                return user;
            }
            rs.close();
        }
        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally {
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
        
        return null;
    }
    
    public static void updateToken(String sql) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
        
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
            //STEP 4: Execute a query
            stmt = conn.createStatement();
        
            stmt.executeUpdate(sql);
        }
        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally {
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
    }
}
*/
