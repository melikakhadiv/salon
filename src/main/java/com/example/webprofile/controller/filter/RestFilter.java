package com.example.webprofile.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter( urlPatterns = "/rest/*")
public class RestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Rest Filter");
        chain.doFilter(request, response);
    }
}
