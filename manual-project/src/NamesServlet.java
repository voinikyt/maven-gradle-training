package com.build.tools.training.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@WebServlet("/names")
public class NamesServlet extends HttpServlet {

    private final ObjectWriter objectWriter = new ObjectMapper()
            .writerWithDefaultPrettyPrinter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<String> names = Arrays.asList("Ivan", "Maria");

        String json = objectWriter.writeValueAsString(names);

        resp.getWriter().write(json);
    }
}
