package com.gsp.gsp.controllers;

import com.gsp.gsp.models.User;
import org.springframework.web.bind.annotation.*;
import com.gsp.gsp.util.DBUtil;
import java.sql.*;

@RestController
@RequestMapping("/")
public class SecurityController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        User user = DBUtil.getUser("SELECT id, firstname, lastname, email, pass, role FROM users WHERE email = '"+ username +"' AND pass = '"+ password+"'");
//        todo convert to JSON and return: GSON
        return "";
    }

    @PostMapping("/logout")
    public String logout() {
        return "";
    }
}
