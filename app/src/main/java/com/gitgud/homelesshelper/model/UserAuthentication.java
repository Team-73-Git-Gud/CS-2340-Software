package com.gitgud.homelesshelper.model;

import android.app.Activity;
import android.util.Log;

import com.firebase.client.Query;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.client.Firebase;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.FirebaseInterface;
import com.gitgud.homelesshelper.model.User;
import com.gitgud.homelesshelper.model.UserAuthentication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Conner Mathis on 3/23/2018.
 */

public class UserAuthentication {
    private Firebase mRef;
    //static FirebaseDatabase database = FirebaseDatabase.getInstance();
    //static DatabaseReference mRef = database.getReference("https://cs-2340-software.firebaseio.com/");
    //Firebase passwordRef = database.getReference("https://cs-2340-software.firebaseio.com/");
    //database.on
    //mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
    private static ArrayList<User> permanence;
    public static ArrayList<String> legalClassification = new ArrayList(Arrays.asList("User", "Admin"));

    public static boolean isValidUser(String s, String t) {

        return isValidUsername(s) && isValidPassword(t);
    }

    public static boolean isValidUsername(String s) {
        //need a firebase already has tbis username in it
        boolean isValid = true;
        for(User user : permanence) {
            //Log.d("username", user.getuserName());
            if(user.getuserName().equals(s)) {
                isValid = false;
            }
        }
        String test = "false";
        if(isValid) {
            test = "true";
        }
        //Log.d("validity", test);
        return isValid && s.length() > 4 &&  s.contains("@");
    }

    public static boolean isValidPassword(String s) {
        //need a firebase already has this password
        //Firebase.setAndroidContext(this);
        //final DatabaseReference dinosaursRef = database.getReference(s);
        boolean isValid = true;
        for(User user : permanence) {
            //Log.d("password", user.getpassWord());
            if(user.getpassWord().equals(s)) {
                isValid = false;
            }
        }



        return  isValid && s.length() > 4;
    }

    public static void setList(ArrayList<User> l) {
        permanence = l;
    }

    public static ArrayList<User> getList() {
        return permanence;
    }

    public static boolean isValidCombination(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("the password and username cannot be null");
        }
        //need a firebase on same user line
        boolean isValid = false;
        for(User user : permanence) {
            if(user.getpassWord().equals(s) && user.getuserName().equals(t)) {
                isValid = true;
            }
        }
        return isValid;
    }

    public static User getCurrentUser(String s) {
        for (User user : permanence) {
            if(user.getuserName().equals(s)) {
                return user;
            }
        }
        return null;
    }
}
