package org.saucedemo.models;

public class User {

    private final String username;
    private final String password;

    public static User STANDARD = new User("standard_user", "secret_sauce");

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
