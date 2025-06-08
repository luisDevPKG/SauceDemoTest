package org.saucedemo.models;

import org.saucedemo.utilities.EnvConfig;

public class User {

    private final String username;
    private final String password;

    public static User STANDARD = new User(
            EnvConfig.get("SAUCEDEMO_USER"),
            EnvConfig.get("SAUCEDEMO_PASSWORD")
    );

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
