package com.gitgud.homelesshelper.model;

import android.support.compat.BuildConfig;

import com.gitgud.homelesshelper.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by collin on 2/13/18.
 */

public class ValidationModel {
    /** Singleton instance */
    private static final ValidationModel _instance = new ValidationModel();
    public static ValidationModel getInstance() { return _instance; }

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private ArrayList<String> dummyCredentials;

    /**
     * Make a new model
     */
    private ValidationModel() {
        dummyCredentials = new ArrayList<>(Arrays.asList( "HelloWorld@gmail.com:foobar", "Main@gmail.com:integer", "Torvalds:opensourceordeath"));
    }
    public Boolean checkAgainstAccounts(/* May have variable args */) {
        return false;
    }

}
