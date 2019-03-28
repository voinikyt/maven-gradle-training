package com.build.tools.training.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/resources")
public class ResourcesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (InputStream infoStream = ResourcesServlet.class.getClassLoader()
                .getResourceAsStream("build-info.properties")) {

            if (infoStream != null) {
                String info = IOUtils.toString(infoStream, StandardCharsets.UTF_8);
                resp.getWriter().write(info);
            } else {
                resp.getWriter().write("Build information is missing");
            }
        }
    }

}
