package com.build.tools.training.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.build.toold.training.projects.ProjectsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet {

    private final ObjectWriter objectWriter = new ObjectMapper()
            .writerWithDefaultPrettyPrinter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProjectsService projectsService = new ProjectsService();

        String json = objectWriter.writeValueAsString(projectsService.getProjects());

        resp.getWriter().write(json);
    }
}
