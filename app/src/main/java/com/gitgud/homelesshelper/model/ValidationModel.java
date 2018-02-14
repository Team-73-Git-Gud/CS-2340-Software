package com.gitgud.homelesshelper.model;

import android.support.compat.BuildConfig;

import com.gitgud.homelesshelper.R;

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
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };



    /**
     * Make a new model
     */
    private ValidationModel() {

    }


    /**
     * populate the model with some dummy data.  The full app would not require this.
     * comment out when adding new courses functionality is present.
     */
    private void loadDummyData() {

    }

    /**
     * Replace an existing students data with new data
     *
     * @param student the student being edited
     */
    public void replaceStudentData() {

    }
}
