package de.dhbwka.studentenfutter.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
    private final boolean loggedIn;
    private final String username;

    public UserBean() {
        this(false, "unknown");
    }

    public UserBean(String username) {
        this(true, username);
    }

    private UserBean(boolean loggedIn, String username) {
        this.loggedIn = loggedIn;
        this.username = username;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUsername() {
        return username;
    }
}
