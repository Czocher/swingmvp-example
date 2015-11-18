package org.czocher.swingmvp.models;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private final Map<String, User> users;

    public UserRepository() {
        users = new HashMap<>();
        users.put("ala", new User("ala", "makota"));
        users.put("czocher", new User("czocher", "czochanski"));
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }
}
