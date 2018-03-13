package com.gitgud.homelesshelper.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csaet on 2/21/2018.
 */

public class User {

    private String userName;
    private String password;
    private String email;
    private String id;
    private static String Class;
    private static String Name;
    private static List<String> usernamelist = new ArrayList<String>();
    private static List<String> passwordlist = new ArrayList<String>();
    private static List<String> namelist = new ArrayList<String>();
    private static List<String> classificationList = new ArrayList<>();
    public static List<String> legalClassification = Arrays.asList("User", "Admin");




    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.id = id;
        this.usernamelist = new ArrayList<String>();
        this.passwordlist = new ArrayList<String>();

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() { return email; }

    public String getId() { return id; }

    public static void setUserName(String userName) {
        if (! (usernamelist.contains(userName))) {
            usernamelist.add(userName);
        }
    }

    public static void setPassword(String password) {
        if (! (passwordlist.contains(password))) {
            passwordlist.add(password);
        }
    }

    public static void setName(String name) {
        if (! (namelist.contains(name))) {
            namelist.add(name);
        }
    }

    public static void setClassification(String name) {
        classificationList.add(name);
    }

    public static void setClass(int i) {
        Class = classificationList.get(i);
    }

    public static void setName(int i) {
        Name = namelist.get(i);
    }

    public static String getName() {
        return Name;
    }

    public static String getClasss() {
        return Class;
    }

    public static String getClassification(int i) {
        return classificationList.get(i);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List getUsernameList() {
        List list = usernamelist;
        return list;
    }

    public List getPasswordList() {
    List list = passwordlist;
    return list;
    }

    public static boolean isValidUsername(String s) {
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
