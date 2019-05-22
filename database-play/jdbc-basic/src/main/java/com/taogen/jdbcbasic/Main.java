package com.taogen.jdbcbasic;

import com.taogen.jdbcbasic.jdbclib.PreparedStatementExample;
import com.taogen.jdbcbasic.jdbclib.StatementExample;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String query = "select * from t_user";
        StatementExample.processSQLwithStatement(query);
        String sql = "update t_user set name = ? where id = ?";
        PreparedStatementExample.processSQLwithPreparedStatement(sql, "zhangsan", 1);
    }
}
