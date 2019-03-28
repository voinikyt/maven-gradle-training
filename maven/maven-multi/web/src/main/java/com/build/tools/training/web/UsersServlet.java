package com.build.tools.training.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import users.UsersService;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private final ObjectWriter objectWriter = new ObjectMapper()
            .writerWithDefaultPrettyPrinter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UsersService usersService = new UsersService();

        String json = objectWriter.writeValueAsString(usersService.getUsers());

        resp.getWriter().write(json);
    }
}
