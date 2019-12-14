package com.gsp.gsp.util;

import com.gsp.gsp.model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<Admin> list = new ArrayList<Admin>();

    public List<Admin> getData() {
        try {
            String url = "jdbc:mysql://localhost:3306/gspdb";
            String username = "root";
            String password = "Dnt0810";
            Connection con = DriverManager.getConnection(url, username, password);
//            PreparedStatement ps = con.prepareStatement("select * from users");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setFirstName(rs.getString("firstname"));
                admin.setLastName(rs.getString("lastname"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("pass"));
                list.add(admin);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        /*try {
            DBUtil test = new DBUtil();
            test.getConnectionUrl();
         /*   Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
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
            System.out.printf("thanh cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        Test t = new Test();
        t.getData();
        for (Admin admin : list) {
            System.out.println(admin.toString());
        }
    }
}
