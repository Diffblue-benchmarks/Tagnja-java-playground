package com.taogen.jdbcbasic.jdbclib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample
{
    public static void processSQLwithPreparedStatement(String sql, Object... args)
    {
        Connection conn = ConnectionExample.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            conn.setAutoCommit(false); // manual commit. once commit multiple statements.
            pstmt.setString(1, String.valueOf(args[0]));
            pstmt.setInt(2, Integer.parseInt(args[1].toString()));
            int updateRow = pstmt.executeUpdate();
            System.out.println("rows: " + updateRow);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.setAutoCommit(true);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
