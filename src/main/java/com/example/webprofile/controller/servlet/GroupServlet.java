package com.example.webprofile.controller.servlet;

import com.example.webprofile.model.service.GroupService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/group")
public class GroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String parentId = req.getParameter("parentId");

            if (parentId == null) {
                req.getSession().setAttribute("parents", GroupService.getService().findParents());
                req.getRequestDispatcher("/group.jsp").forward(req, resp);
            }else{
                System.out.println(GroupService.getService().findByParentId(Integer.parseInt(parentId)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
