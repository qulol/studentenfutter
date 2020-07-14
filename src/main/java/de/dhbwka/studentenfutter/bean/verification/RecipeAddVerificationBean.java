package de.dhbwka.studentenfutter.bean.verification;

import java.util.regex.Pattern;

public class RecipeAddVerificationBean {
    private final Pattern recipeTitleVerification;

    public RecipeAddVerificationBean() {
        recipeTitleVerification = Pattern.compile("([a-zA-ZäöüÄÖÜß]|\\d)*(\\s([a-zA-ZäöüÄÖÜß]|\\d)+)*");
    }

    public Pattern getRecipeTitleVerification() {
        return recipeTitleVerification;
    }
}