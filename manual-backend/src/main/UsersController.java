package com.build.tools.training.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@WebServlet("/users")
public class UsersController extends HttpServlet {

    private final ObjectWriter objectWriter = new ObjectMapper()
            .writerWithDefaultPrettyPrinter();

    private final UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<User> users = usersService.parseUsers();

        String json = objectWriter.writeValueAsString(users);

        resp.getWriter().write(json);
    }
}
