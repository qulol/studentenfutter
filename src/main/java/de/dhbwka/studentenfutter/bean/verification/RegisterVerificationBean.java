package de.dhbwka.studentenfutter.bean.verification;

import java.util.regex.Pattern;

public class RegisterVerificationBean {
    private final Pattern usernameVerification;
    private final Pattern passwordVerification;

    public RegisterVerificationBean() {
        this.usernameVerification = Pattern.compile("[a-zA-ZäöüÄÖÜß]");
        this.passwordVerification = Pattern.compile("[a-zA-ZäöüÄÖÜß]");
    }

    public Pattern getUsernameVerification() {
        return usernameVerification;
    }

    public boolean isValidUsername(String username) {
        return usernameVerification.matcher(username).matches();
    }

    public Pattern getPasswordVerification() {
        return passwordVerification;
    }

    public boolean isValidPassword(String password) {
        return passwordVerification.matcher(password).matches();
    }
}
