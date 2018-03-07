package com.gitgud.homelesshelper.model;

import android.support.compat.BuildConfig;

import java.util.ArrayList;

import com.gitgud.homelesshelper.R;

/**
 * Created by Collin Avidano on 1/13/18.
 */

public class MainModel {
    /** Singleton instance */
    private static final MainModel _instance = new MainModel();
    public static MainModel getInstance() { return _instance; }


    /**
     * Make a new model
     */
    private MainModel() {

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

