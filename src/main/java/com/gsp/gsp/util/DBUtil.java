package com.gsp.gsp.util;

import com.gsp.gsp.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBUtil {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/gsp";

    private static final String USER = "root";
    private static final String PASS = "admin";

    public static User getUserLogin(String sql) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            User user = new User();
            while (rs.next()) {
                user.setId(rs.getString("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPass(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setToken(rs.getString("token"));
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
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateToken(String sql) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<User> getUser(String sql) {
        Connection conn = null;
        Statement stmt = null;
        List<User> listUser = new ArrayList<User>();
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = new User(rs.getString("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("token")
                );
                listUser.add(user);
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public static User getUserByID(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = '" + id + "' ");
            User user = new User();
            while (rs.next()) {
                user.setId(rs.getString("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPass(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setToken(rs.getString("token"));
            }
            rs.close();
            return user;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteUser(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM users WHERE id = '" + id + "' ");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
