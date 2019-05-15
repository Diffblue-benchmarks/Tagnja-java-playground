package com.taogen.i18nfordbjavaweb;

import com.taogen.i18nfordbjavaweb.DAO.UserCache;
import com.taogen.i18nfordbjavaweb.entity.User;
import com.taogen.i18nfordbjavaweb.util.I18nUtils;

import java.sql.*;
import java.util.Locale;

/**
 * H2 Database Sample SQL:
 * DROP TABLE IF EXISTS TEST;
 * CREATE TABLE TEST(ID INT PRIMARY KEY,
 *    NAME VARCHAR(255));
 * INSERT INTO TEST VALUES(1, 'Hello');
 * INSERT INTO TEST VALUES(2, 'World');
 * SELECT * FROM TEST ORDER BY ID;
 * UPDATE TEST SET NAME='Hi' WHERE ID=1;
 * DELETE FROM TEST WHERE ID=2;
 */
public class Main
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
//        Class.forName ("org.h2.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
//        System.out.println(connection);
//        Statement st = connection.createStatement();
////        st.execute("insert into TEST values ( 1, 'taogen')");
//        ResultSet resultSet = st.executeQuery("select * from TEST");
//        System.out.println(resultSet);
//        st.close();
//        connection.close();


//        System.out.println(UserCache.getList());
//        System.out.println(UserCache.add(new User(1, "Taogen1")));
//        System.out.println(UserCache.add(new User(2, "Taogen2")));
//        System.out.println(UserCache.getList());
//        System.out.println(UserCache.remove(3));
//        System.out.println(UserCache.remove(2));
//        System.out.println(UserCache.getList());
        System.out.println(I18nUtils.getMessage("errorCode.success", new Locale("zh", "CN")));

    }
}
