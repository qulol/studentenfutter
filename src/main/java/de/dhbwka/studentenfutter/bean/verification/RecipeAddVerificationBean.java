package de.dhbwka.studentenfutter.bean.verification;

import java.util.regex.Pattern;

public class RecipeAddVerificationBean {
    private final Pattern recipeTitleVerification;

    public RecipeAddVerificationBean() {
        recipeTitleVerification = Pattern.compile("([a-zA-ZäöüÄÖÜß]|\\d)*((\\s|-)([a-zA-ZäöüÄÖÜß]|\\d)+)*");
    }

    public Pattern getRecipeTitleVerification() {
        return recipeTitleVerification;
    }

    public String getRecipeTitleVerificationMessage() {
        return "Der Name darf nur Zahlen oder Buchstaben enthalten "
            + "und einzelne Wörter müssen mit Leerzeichen oder '-' getrennt werden.";
    }
}