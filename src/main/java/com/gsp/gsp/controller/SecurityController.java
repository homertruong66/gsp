package com.gsp.gsp.controller;

import com.google.gson.Gson;
import com.gsp.gsp.model.User;
import org.springframework.web.bind.annotation.*;
import com.gsp.gsp.util.DBUtil;

@RestController
public class SecurityController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        String sql = "SELECT id, email, password, first_name, last_name, role, token " +
                     "FROM users u " +
                     "WHERE u.email = '" + username + "' " +
                     "AND u.password = '" + password + "'";
        
        User user = DBUtil.getUser(sql);
        Gson gson = new Gson();
        String json = gson.toJson(user);
        return json;
    }

    @PostMapping("/logout")
    public String logout(@RequestParam String id) {
        String deleteTokenSql = "UPDATE users u " +
                                "SET u.token = NULL " +
                                "WHERE u.id = '" + id + "'";
        DBUtil.updateToken(deleteTokenSql);
        
        return "OK";
    }
}
