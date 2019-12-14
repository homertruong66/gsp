package com.gsp.gsp.controller;

import com.gsp.gsp.dao.LoginDao;
import com.gsp.gsp.model.Admin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/admin")
public class LoginAdmin extends HttpServlet {
    public LoginAdmin() { }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        Admin loginAdmin = new Admin();

        loginAdmin.setEmail(userName);
        loginAdmin.setPassword(password);

        LoginDao loginDao = new LoginDao();

        String userValidate = null;
        try {
            //Calling authenticateUser function
            userValidate = loginDao.authenticateUser(loginAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userValidate.equals("SUCCESS"))
        {
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("").forward(request, response);
        } else {
            request.setAttribute("errMessage", userValidate);
            request.getRequestDispatcher("").forward(request, response);
        }
    }
}
