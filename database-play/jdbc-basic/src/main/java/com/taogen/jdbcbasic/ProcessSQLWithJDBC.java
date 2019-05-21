package com.taogen.jdbcbasic;

import java.sql.*;
import java.util.Properties;

public class ProcessSQLWithJDBC
{
    public static void main(String[] args) throws Exception
    {
        // Establishing a connection
        Connection conn = getConnection();
        Statement stmt = null;
        String query = "select * from t_user";
        try
        {
            // Create a statement
            stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Process the ResultSet
            while (rs.next())
            {
                System.out.println(rs.getRow());
            }

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            // Close Connection
            stmt.close();
            conn.close();
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        //Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        Properties concetionProps = new Properties();
        concetionProps.put("user", "root");
        concetionProps.put("password", "justdoit");
        conn = DriverManager.getConnection(url, concetionProps);
        System.out.println("Connected to database");
        return conn;
    }
}
