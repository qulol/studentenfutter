//package de.dhbwka.studentenfutter;
//
//import org.languagetool.JLanguageTool;
//import org.languagetool.language.GermanyGerman;
//import org.languagetool.rules.RuleMatch;
//
//import java.io.IOException;
//import java.util.List;
//
//public class SpellCheckTest {
//    private static JLanguageTool languageTool = new JLanguageTool(new GermanyGerman());
//
//    public static void main(String[] args) {
//        try {
//            check("Sahnne Zuxker Mehk");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void check(String str) throws IOException {
//        List<RuleMatch> matches = languageTool.check(str);
//        for (RuleMatch match : matches) {
//            System.out.println("Potential error at characters " +
//                    match.getFromPos() + "-" + match.getToPos() + ": " +
//                    match.getMessage());
//            System.out.println("Suggested correction(s): " +
//                    match.getSuggestedReplacements());
//        }
//    }
//}