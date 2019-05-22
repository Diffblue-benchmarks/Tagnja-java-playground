package com.taogen.jdbcbasic.jdbclib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionExample
{
    private static Connection conn;

    public static Connection getConnection()
    {
        try
        {
            if (conn != null && ! conn.isClosed())
            {
                return conn;
            }

            String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            //Class.forName("com.mysql.jdbc.Driver");
            Properties concetionProps = new Properties();
            concetionProps.put("user", "root");
            concetionProps.put("password", "justdoit");
            conn = DriverManager.getConnection(url, concetionProps);
            //conn = DriverManager.getConnection(url, "root", "justdoit");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("Connected to database. Connection is " + conn);
        return conn;
    }
}
