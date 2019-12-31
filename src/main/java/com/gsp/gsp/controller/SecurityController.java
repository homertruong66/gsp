package com.gsp.gsp.controller;

import com.google.gson.Gson;
import com.gsp.gsp.model.LoginForm;
import com.gsp.gsp.model.User;
import com.gsp.gsp.model.UserInfo;
import org.springframework.web.bind.annotation.*;
import com.gsp.gsp.util.NewDBUtils;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SecurityController {

    @PostMapping("/login")
    public String login(@RequestBody LoginForm loginForm) {

        String sql = "SELECT id, email, password, first_name, last_name, role, token " +
                     "FROM users u " +
                     "WHERE u.email = '" + loginForm.getUsername() + "' " +
                     "AND u.password = '" + loginForm.getPassword() + "'";

        User user = NewDBUtils.getUser(sql);
        Gson gson = new Gson();
        return gson.toJson(user);
    }

    @PostMapping("/logout")
    public String logout(@RequestBody UserInfo userInfo) {

        String deleteTokenSql = "UPDATE users u " +
                                "SET u.token = NULL " +
                                "WHERE u.id = '" + userInfo.getId() + "'";

        NewDBUtils.updateToken(deleteTokenSql);

        return "OK";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestBody UserInfo userInfo) {

        String changePassword = "UPDATE users u " +
                                "SET u.password = '" + userInfo.getNewPassword() + "' " +
                                "WHERE u.email = '" + userInfo.getUsername() + "' " +
                                "AND u.password = '" + userInfo.getOldPassword() + "'";

        NewDBUtils.updatePassword(changePassword);
        return "OK";
    }
}
