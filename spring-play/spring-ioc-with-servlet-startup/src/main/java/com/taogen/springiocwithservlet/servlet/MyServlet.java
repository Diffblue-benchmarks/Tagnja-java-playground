package com.taogen.springiocwithservlet.servlet;

import com.taogen.springiocwithservlet.bean.MyBean;
import com.taogen.springiocwithservlet.utils.SpringUtils;

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
        // Using ioc bean in servlet. By utility class get bean.
        //MyBean myBean = (MyBean) SpringUtils.getBean("MyBean");

        try {
            PrintWriter pw = response.getWriter();
            pw.write("Hello by MyServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
