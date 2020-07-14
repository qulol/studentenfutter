package de.dhbwka.studentenfutter.bean.verification;

import java.util.regex.Pattern;

public class RegisterVerificationBean {
    private final Pattern usernameVerification;
    private final Pattern passwordVerification;

    public RegisterVerificationBean() {
        this.usernameVerification = Pattern.compile("([a-zA-ZäöüÄÖÜß]|\\d){2,}");
        this.passwordVerification = Pattern.compile("([a-zA-ZäöüÄÖÜß]|\\d){2,}");
    }

    public Pattern getUsernameVerification() {
        return usernameVerification;
    }

    public boolean isValidUsername(String username) {
        return usernameVerification.matcher(username).matches();
    }

    public String getUsernameVerificationMessage() {
        return "Der eingegebene Benutzername muss mindestens 2 Buchstaben oder Zahlen enthalten.";
    }

    public Pattern getPasswordVerification() {
        return passwordVerification;
    }

    public boolean isValidPassword(String password) {
        return passwordVerification.matcher(password).matches();
    }

    public String getPasswordVerificationMessage() {
        return "Das eingegebene Passwort muss mindestens 2 Buchstaben oder Zahlen enthalten.";
    }
}
