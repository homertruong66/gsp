package com.gsp.gsp.controller;

import com.gsp.gsp.model.Admin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping("/")
public class SerurityController {
    static final String DB_URL = "jdbc:mysql://localhost/gspdb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        int x = (int) Math.sqrt(9);
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

            String sql = "SELECT id, firstname, lastname, email, pass, role FROM users WHERE email = '"+ username +"' AND pass = '"+ password+"'";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
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
                byte role = rs.getByte("role");
//                admin.setRole(role);
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

            if (admin.getId()!=-1) {
                // Todo: generalize token and save to database add to user""
                // Create util package (class DBUtil get(sql query), create(sql query), update(sql query), delete(sql query))
                return admin.toString();
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

    @PostMapping("/logout")
    public String logout() {
        return "";
    }
}
