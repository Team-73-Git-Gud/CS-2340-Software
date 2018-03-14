package com.gitgud.homelesshelper.model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by collin on 3/13/18.
 */

public class SearchProvider {
    private static ArrayList<Shelter> result;
    public static boolean ischanged=false;

    public static void search(ArrayList<Shelter> list, String nameField, String genderField, String ageField) {
        //variables
        result = new ArrayList<>(list);
        String nameString = nameField;
        String genderString = null;
        String ageString = "";
        //defining variables
        //for name
        //for gender
        if (genderField.contains("MALE")) {
            genderString = "Men";
        }
        if (genderField.contains("FEMALE")) {
            genderString = "Women";
        }
        if (genderField.contains("ANYONE")) {
            genderString = null;
        }
        //for age
        if (ageField.contains("ANYONE")) {
            ageString = "anyone";
        }
        if (ageField.contains("CHILDREN")) {
            ageString = "children";
        }
        if (ageField.contains("YOUNG_ADULTS")) {
            ageString = "young";
        }
        if (ageField.contains("FAMILIES_AND_NEWBORNS")) {
            ageString = "families";
        }

        //for loop to go through array
        for (Shelter obj : list) {
            Log.d("LOOP", obj.getRestriction());
            /**
            if ((!((obj.getRestriction().toLowerCase()).contains("anyone")))) {
                Log.d("LOOP", "doesnt contain anyone");
             */
                if (!(nameString == null)) {
                    if (!((obj.getName().toLowerCase()).contains(nameField.toLowerCase()))) {
                        result.remove(obj);
                    }
                }
                if (!(genderString == null)) {
                    if (!((obj.getRestriction()).contains(genderString))) {
                        result.remove(obj);
                    }
                }
                if (!(ageString == null)) {
                    if (!((obj.getRestriction().toLowerCase()).contains(ageString.toLowerCase()))) {
                        result.remove(obj);
                    }
                }

            /*
            if (!(nameString == null)) {
                if (!((obj.getName().toLowerCase()).contains(nameField.toLowerCase()))) {
                    result.remove(obj);
                }
            }
            */
            Log.d("LOOP", "------------------------");
        }
    }




    public static ArrayList<Shelter> getSearchResult() {
        return result;
    }

}
