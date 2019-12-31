package com.gsp.gsp.util;

import com.gsp.gsp.model.User;

import java.sql.*;
import java.util.UUID;

public class NewDBUtils {

    private static final String hostname = "localhost";
    private static final String dbName = "gsp";
    private static final String username = "root";
    private static final String password = "admin";
    // jdbc:mysql://hostname:port/dbname
    private static final String connectionURL = "jdbc:mysql://" + hostname + ":3306/" + dbName;

    static Connection openConnection() throws SQLException {
        // 1. Load Driver
        // Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        // 2. Open connection
        return DriverManager.getConnection(connectionURL, username, password);
    }

    public static User getUser(String sql) {
        try (
                Connection con = openConnection();
                Statement st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery(sql);
        ) {
            User user = new User();
            while (rs.next()) {
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
        } catch (Exception se) {
            se.printStackTrace();
        }
        return null;
    }

    public static void updateToken(String sql) {
        try (
                Connection con = openConnection();
                Statement st = con.createStatement();
        ) {
            st.executeUpdate(sql);
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    public static void updatePassword(String sql) {
        try (
                Connection con = openConnection();
                Statement st = con.createStatement();
        ) {
            st.executeUpdate(sql);
        } catch (Exception se) {
            se.printStackTrace();
        }
    }
}


