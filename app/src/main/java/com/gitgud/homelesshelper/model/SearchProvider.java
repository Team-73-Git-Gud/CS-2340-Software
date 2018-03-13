package com.gitgud.homelesshelper.model;

import java.util.ArrayList;

/**
 * Created by collin on 3/13/18.
 */

public class SearchProvider {
    private static ArrayList<Shelter> result;

    public static void search(ArrayList<Shelter> list, String nameField, String genderField, String ageField) {
        if (!result.isEmpty()) {
            result = null;
        } else {
            result = new ArrayList<>(list);
        }

        for (Shelter obj: list) {
            if (nameField != null) {
                if (!(obj.getName()).contains(nameField)) {
                    result.remove(obj);
                }
            }
            if (genderField != null) {
                if (!(obj.getRestriction()).contains(genderField)) {
                    result.remove(obj);
                }
            }
            if (ageField != null) {
                if (!(obj.getRestriction()).contains(ageField)) {
                    result.remove(obj);
                }
            }
        }
    }

    public static ArrayList<Shelter> getSearchResult() {
        return result;
    }

}
