package com.gsp.gsp.controllers;

import com.gsp.gsp.models.User;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;
import com.gsp.gsp.util.DBUtil;
import java.sql.*;
import com.gsp.gsp.token.JWTToken;
@RestController
@RequestMapping("/")
public class SecurityController {
    @PostMapping("/login")
    public Claims login(@RequestParam String username, @RequestParam String password) throws SQLException, ClassNotFoundException {
        Connection connection = DBUtil.connection();
        Statement statement = connection.createStatement();
        String sql = "SELECT id, firstname, lastname, email, pass, role FROM users WHERE email = '" + username + "' AND pass = '" + password + "'";
        ResultSet rs = statement.executeQuery(sql);
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


        if (user.getId() != -1) {
            // Todo: generalize token and save to database add to user""
             String createJWT = JWTToken.createJWT(user.getLastName() + user.getFirstName(),user.getPass(),user.getEmail(),10000);
             System.out.println(createJWT);
             Claims claims =  JWTToken.decodeJWT(createJWT);
             return claims;

            // Create util package (class DBUtil get(sql query), create(sql query), update(sql query), delete(sql query))
            //return user.toString();
        }
        rs.close();

        return null;
    }

    @PostMapping("/logout")
    public String logout() {
        return "";
    }
}
