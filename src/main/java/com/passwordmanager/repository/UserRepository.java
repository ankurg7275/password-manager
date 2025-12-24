package com.passwordmanager.repository;

import com.passwordmanager.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static Map<String, User> users = new HashMap<>();

    public static boolean exists(String username) {
        return users.containsKey(username);
    }

    public static void save(User user) {
        users.put(user.getUsername(), user);
    }

    public static User find(String username) {
        return users.get(username);
    }
}
