package de.dhbwka.studentenfutter.bean.verification;

import java.util.regex.Pattern;

public class RecipeSearchVerificationBean {
    private final Pattern searchVerification;

    public RecipeSearchVerificationBean() {
        this.searchVerification = Pattern.compile("([a-zA-ZäöüÄÖÜß]|\\d)*((\\s|-)([a-zA-ZäöüÄÖÜß]|\\d)+)*");
    }

    public Pattern getSearchVerification() {
        return searchVerification;
    }

    public boolean isValidSearch(String search) {
        return searchVerification.matcher(search).matches();
    }

    public String getVerificationMessage() {
        return "Die Eingabe muss mindestens 1 Buchstaben oder Zahl enthalten," +
                " und Wörter dürfen von nur einem Leerzeichen oder Bindestrich getrennt sein.";
    }
}
