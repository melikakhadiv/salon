package com.example.webprofile.controller.servlet;

import com.example.webprofile.controller.session.SessionManager;
import com.example.webprofile.model.entity.User;
import com.example.webprofile.model.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            if (userName != null && password != null) {
                User user = UserService.getService().login(userName,password);
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("user", user);
                SessionManager.addHttpSession(httpSession);
                resp.sendRedirect("/jsp/person.jsp");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");

            if (userName != null && password != null) {
                HttpSession httpSession = req.getSession();
                User user = User.builder().userName(userName).password(password).build();
                UserService.getService().save(user);
                httpSession.setAttribute("user", user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
    }
}
