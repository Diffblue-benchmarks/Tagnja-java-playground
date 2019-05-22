package com.taogen.jdbcbasic.jdbclib;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Statement
 *   boolean execute(String sql)
 *   ResultSet executeQuery(String sql)
 *   int executeUpdate(String sql)
 *   int[] executeBatch()
 */
public class StatementExample
{
    public static void processSQLwithStatement(String sql)
    {
        // Establishing a connection
        Connection conn = ConnectionExample.getConnection();
        Statement stmt = null;

        try
        {
            // Create a statement
            stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(sql);

            // Process the ResultSet
            while (rs.next())
            {
                System.out.println(rs.getString(1) + "," + rs.getString(2));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            // Close resource
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void processSQLwithStatementWithAutoClose(String sql)
    {
        Connection conn = ConnectionExample.getConnection();
        try(Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                System.out.println(rs.getString(1) + "," + rs.getString(2));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
