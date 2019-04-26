package com.taogen.springiocwithservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            PrintWriter pw = response.getWriter();
            pw.write("Hello by MyServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
