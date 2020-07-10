package de.dhbwka.studentenfutter.bean.verification;

import java.util.regex.Pattern;

public class RecipeSearchVerificationBean {
    private final Pattern searchVerification;

    public RecipeSearchVerificationBean() {
        this.searchVerification = Pattern.compile("([a-zA-ZäöüÄÖÜß]|\\d)*");
    }

    public Pattern getSearchVerification() {
        return searchVerification;
    }

    public boolean isValidSearch(String search) {
        return searchVerification.matcher(search).matches();
    }
}
