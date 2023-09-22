package com.example.webprofile.controller.servlet;

import com.example.webprofile.controller.session.SessionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/monitor")
public class Monitor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("sessions", SessionManager.sessionMap);
        req.getRequestDispatcher("/monitor.jsp").forward(req,resp);
    }
}
