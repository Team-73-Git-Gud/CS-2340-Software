package com.gitgud.homelesshelper.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by collin on 3/23/18.
 */

public class ValidationUtils {
    // This class will replace the validation methods in user and across attemptLogin() in login so that, one, validation is consistent, and two, validation is compact
    public static ArrayList<String> legalClassification = new ArrayList(Arrays.asList("User", "Admin"));

    public static boolean isValidUser(String s, String t) {
        return isValidUsername(s) && isValidPassword(t) && isValidCombination(s, t);
    }

    public static boolean isValidUsername(String s) {
        //need a firebase already has this username in it check instead of arraylist check
        return  !usernamelist.contains(s) && s.length() > 4 &&  s.contains("@");
    }

    public static boolean isValidPassword(String s) {
        //need a firebase already has this password
        return  !passwordlist.contains(s) && s.length() > 4;
    }

    public static boolean isValidCombination(String s, String t) {
        //need a firebase on same user line
        return usernamelist.indexOf(s) == passwordlist.indexOf(t);
    }
}
