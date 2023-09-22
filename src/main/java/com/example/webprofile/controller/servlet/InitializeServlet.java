package com.example.webprofile.controller.servlet;

import com.example.webprofile.model.entity.User;
import com.example.webprofile.model.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/init")
public class InitializeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Load On Startup");
        try {
            System.out.println(UserService.getService().save(
                    User.builder().userName("admin").password("admin").build()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
