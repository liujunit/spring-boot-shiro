package com.liujunit.shirodemo.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {

    private static final Map<String, Map<String, String>> dataSource = new HashMap<>();

    static {
        //用户1
        Map<String, String> user1 = new HashMap<>();
        user1.put("password", "smith123");
        user1.put("role", "user");
        user1.put("permission", "view");
        dataSource.put("smith", user1);
        //用户2
        Map<String, String> user2 = new HashMap<>();
        user2.put("password", "danny123");
        user2.put("role", "admin");
        user2.put("permission", "view,edit");
        dataSource.put("danny", user2);
    }

    public UserBean getUser(String username) {
        // 没有此用户直接返回null
        if (!dataSource.containsKey(username))
            return null;
        UserBean user = new UserBean();
        Map<String, String> detail = dataSource.get(username);
        user.setUsername(username);
        user.setPassword(detail.get("password"));
        user.setRole(detail.get("role"));
        user.setPermission(detail.get("permission"));
        return user;
    }
}
