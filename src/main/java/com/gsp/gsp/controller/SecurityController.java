package com.gsp.gsp.controller;

import com.google.gson.Gson;
import com.gsp.gsp.model.User;
import org.springframework.web.bind.annotation.*;
import com.gsp.gsp.util.NewDBUtils;

@RestController
public class SecurityController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        String sql = "SELECT id, email, password, first_name, last_name, role, token " +
                     "FROM users u " +
                     "WHERE u.email = '" + username + "' " +
                     "AND u.password = '" + password + "'";
        
        User user = NewDBUtils.getUser(sql);
        Gson gson = new Gson();

        return gson.toJson(user);
    }

    @PostMapping("/logout")
    public String logout(@RequestParam String id) {

        String deleteTokenSql = "UPDATE users u " +
                                "SET u.token = NULL " +
                                "WHERE u.id = '" + id + "'";

        NewDBUtils.updateToken(deleteTokenSql);

        return "OK";
    }
    @PostMapping("/change-password")
    public String changePassword(@RequestParam String username, @RequestParam String oldPassword, @RequestParam String newPassword) {

        String changePassword = "UPDATE users u " +
                                "SET u.password = '" + newPassword + "'" +
                                "WHERE u.email = '" + username + "' " +
                                "AND u.password = '" + oldPassword + "'";

        NewDBUtils.updatePassword(changePassword);
        return "OK";
    }
}
