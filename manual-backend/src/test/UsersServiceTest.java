package com.build.tools.training.web;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class UsersServiceTest {

    @Test
    public void testParsing() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        when(response.getWriter()).thenReturn(pw);

        new UsersController().doGet(request, response);

        String actual = sw.getBuffer().toString();
        String expected = readExpectedJsonFile();

        assertEquals(expected, actual);
    }

    private String readExpectedJsonFile() throws IOException {
        String filePaht = UsersServiceTest.class.getClassLoader()
                .getResource("response.json")
                .getFile();
        return FileUtils.readFileToString(new File(filePaht), UTF_8);
    }

}
