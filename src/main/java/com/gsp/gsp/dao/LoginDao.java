package com.gsp.gsp.dao;

import com.gsp.gsp.model.Admin;
import com.gsp.gsp.util.DBUtil;

import java.sql.*;

public class LoginDao {
    public LoginDao() { }

    public String authenticateUser(Admin Admin) throws Exception {
        String username = Admin.getEmail(); //Keeping user entered values in temporary variables.
        String password = Admin.getPassword();
        String usernameDB = "";
        String passwordDB = "";
        DBUtil conn = new DBUtil();
//        try (
//                Connection con = DriverManager.getConnection();
//                Statement statement = con.createStatement();
//                ResultSet rs = statement.executeQuery("select * from users");
//        ) {
//            while (rs.next()) // Until next row is present otherwise it return false
//            {
//                usernameDB = rs.getString("email"); //fetch the values present in database
//                passwordDB = rs.getString("pass");
//
//                if (username.equals(usernameDB) && password.equals(passwordDB)) {
//                    return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return "Invalid user credentials"; // Just returning appropriate message otherwise
    }
}

