package com.gitgud.homelesshelper.model;

/**
 * Created by collin on 3/23/18.
 */

public class ValidationUtils {
    // This class will replace the validation methods in user and across attemptLogin() in login so that, one, validation is consistent, and two, validation is compact
    public static boolean isValidEmail(String s) {
        return  usernamelist.contains(s) && s.length() > 4 &&  s.contains("@");
    }

    public static boolean isValidPassword(String s) {
        return  passwordlist.contains(s) && s.length() > 4;
    }

    public static boolean isEnterablePassword(String s) {
        return  ! passwordlist.contains(s) && s.length() > 4;
    }

    public static boolean isEnterableUsername(String s) {
        return  (! (usernamelist.contains(s))) && s.length() > 4 &&  s.contains("@");
    }

    public static int indexOfUser(String s) {
        return usernamelist.indexOf(s);
    }


    public static boolean isValidCombination(String s, String t) {
        return usernamelist.indexOf(s) == passwordlist.indexOf(t);
    }
}
