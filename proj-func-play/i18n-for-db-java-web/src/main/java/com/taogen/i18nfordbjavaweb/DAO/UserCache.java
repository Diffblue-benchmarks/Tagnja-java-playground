package com.taogen.i18nfordbjavaweb.DAO;

import com.taogen.i18nfordbjavaweb.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserCache
{
    public static Map<Integer, User> userMap = new HashMap<>();
    public static List<User> userList = new CopyOnWriteArrayList<>();

    public static List<User> getList()
    {
        return userList;
    }
    public static boolean add(User u)
    {
        if (u != null && u.getId() != null)
        {
            if (userMap.get(u.getId()) == null)
            {
                userList.add(userList.size(), u);
                userMap.put(u.getId(), u);
                return true;
            }
        }
        return false;
    }

    public static boolean remove(Integer userId)
    {
        if (userId != null && userMap.get(userId) != null && userList.size() > 0)
        {
            int i = 0;
            for (; i < userList.size(); i++) {
                if (userId.equals(userList.get(i).getId()))
                {
                    break;
                }
            }
            if (i < userList.size())
            {
                userList.remove(i);
                userMap.remove(userId);
                return true;
            }
        }
        return false;
    }
}
