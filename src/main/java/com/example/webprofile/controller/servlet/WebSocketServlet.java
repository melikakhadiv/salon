package com.example.webprofile.controller.servlet;

import com.example.webprofile.controller.socket.WsServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/broadcast")
public class WebSocketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WsServer.broadcast("Broadcast to all");
//        String realIp = req.getHeader("X-FORWARDED-FOR");
//        if(realIp==null){
//            realIp= req.getRemoteAddr();
//        }
//        System.out.println(realIp);
    }
}
