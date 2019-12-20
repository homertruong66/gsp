package com.gsp.gsp.controller;

import com.google.gson.Gson;
import com.gsp.gsp.model.User;
import com.gsp.gsp.util.DBUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/alluser")
    public String getAllUsers() {
        List<User> listUser = DBUtil.getUser("SELECT * FROM users ");
        ;
        return new Gson().toJson(listUser);
    }

//    public List<User> getAllUser(){
//        return DBUtil.getAllUsers();
//    }

    @PostMapping("/search")
    public String searchAdmin(@RequestParam String txtSearch) {
        String sql = "SELECT * FROM users u " +
                "WHERE (u.first_name LIKE '%" + txtSearch + "%') " +
                "OR (u.last_name LIKE '%" + txtSearch + "%') " +
                "OR (u.email LIKE '%" + txtSearch + "%')";
        List<User> listUsers = new ArrayList<User>();
        listUsers = DBUtil.getUser(sql);
        Gson gson = new Gson();
        String json = gson.toJson(listUsers);
        return json;
    }

    @DeleteMapping("/destroy/{id}")
    public String deleteUser(@PathVariable String id) {
        if (id == null)
            return "id not null ";
        DBUtil.deleteUser(id);
        return "Delete successful";
    }

}

