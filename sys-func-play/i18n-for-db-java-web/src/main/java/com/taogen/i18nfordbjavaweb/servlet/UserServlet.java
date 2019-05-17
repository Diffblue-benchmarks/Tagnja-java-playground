package com.taogen.i18nfordbjavaweb.servlet;

import com.taogen.i18nfordbjavaweb.DAO.UserCache;
import com.taogen.i18nfordbjavaweb.entity.User;
import com.taogen.i18nfordbjavaweb.util.I18nUtils;
import com.taogen.i18nfordbjavaweb.util.LocaleUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Locale;

public class UserServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        resp.setContentType("text/html;charset=utf-8");

        String uri = req.getRequestURI();
        String localeStr = req.getParameter("locale");
        req.setAttribute("locale", localeStr);
        Locale locale = LocaleUtils.getLocaleByStr(LocaleUtils.getRightLocaleStr(localeStr));
        System.out.println("servlet path:" + req.getServletPath());
        if (uri.contains("getAll"))
        {
            //writer.write(UserCache.getList().toString());
            req.setAttribute("userList", UserCache.getList());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        else
        {
            String message = "result";
            if(uri.contains("add"))
            {
                Integer userId = Integer.valueOf(req.getParameter("id"));
                String userName = req.getParameter("name");
                if (UserCache.add(new User(userId, userName))) {
                    message = I18nUtils.getMessage("errorCode.success", locale) + "---" + new Date();
                }
                else
                {
                    message = I18nUtils.getMessage("errorCode.fail", locale) + "--" + new Date();
                }
            }
            else if (uri.contains("remove"))
            {
                Integer userId = Integer.valueOf(req.getParameter("userId"));
                if (UserCache.remove(userId))
                {
                    message = I18nUtils.getMessage("errorCode.success", locale) + "--" + new Date();
                }
                else
                {
                    message = I18nUtils.getMessage("errorCode.fail", locale) + "--" + new Date();
                }
            }
            req.setAttribute("message", message);
            req.getRequestDispatcher("/result.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
