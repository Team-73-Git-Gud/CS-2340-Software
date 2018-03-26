//package com.gitgud.homelesshelper.model;
//
//import android.support.annotation.NonNull;
//import android.util.Log;
//
//import java.util.ArrayList;
//
///**
// * Created by csaet on 2/24/2018.
// */
//
//public class Shelter implements Comparable<Shelter>{
//
//
//
//    private static ArrayList<Shelter> shelterList = new ArrayList<>();
//    public static String SHELTER_NAME = "shelter_name";
//
//    private String id;
//    private String name;
//    private String capacity;
//    private int vacancy;
//    private String restriction;
//    private String longitude;
//    private String latitude;
//    private String address;
//    private String notes;
//    private String number;
//
//    public Shelter(String id, String name, String capacity, String restriction, String longitude,
//                   String latitude, String address, String notes, String number){
//        this.id = id;
//        if (name == null) {
//            this.name = "N/a";
//        } else{
//            this.name = name;
//        }
//        this.name = name;
//        if (capacity == null) {
//            this.capacity = "N/a";
//        } else{
//            this.capacity = capacity;
//        }
//        this.restriction = restriction;
//        this.longitude = longitude;
//        this.latitude = latitude;
//        this.address = address;
//        this.notes = notes;
//        this.number = number;
//        if (capacity == null) {
//        //    this.vacancy = 0;
//        } else {
//        //    this.vacancy = Integer.parseInt(capacity);
//        }
//        if(!shelterList.contains(this)) {
//            shelterList.add(this);
//        }
//        Log.e("myApp", "length is " + shelterList.size());
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    //public int getVacancy() { return vacancy;}
//
//    public String getName() {
//        return name;
//    }
//
//    public String getCapacity() {
//        return capacity;
//    }
//
//    public String getRestriction() {
//        return restriction;
//    }
//
//    public String getLongitude() {
//        return longitude;
//    }
//
//    public String getLatitude() {
//        return latitude;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public String getNotes() {
//        return notes;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public static ArrayList<Shelter> getShelterList() {
//        return shelterList;
//    }
//
//
//    public static Shelter findShelter(String id) {
//        return shelterList.get(Integer.parseInt(id));
//    }
//
//    public boolean equals(Object o) {
//        Shelter k = (Shelter) o;
//        return this.name.equals(k.getName());
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//
//    @Override
//    public int compareTo(@NonNull Shelter o) {
//        return this.getName().compareTo(o.getName());
//    }
//}

package com.gitgud.homelesshelper.model;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by csaet on 2/24/2018.
 */

public class Shelter implements Comparable<Shelter>{



    private static ArrayList<Shelter> shelterList = new ArrayList<>();
    public static String SHELTER_NAME = "shelter_name";

    private String id;
    private String name;
    private String capacity;
    private String restriction;
    private String longitude;
    private String latitude;
    private String address;
    private String notes;
    private String number;
    private int individual;
    private int family;
    private int[] familyArray = new int[] {0, 1, 2, 3};
    private int[] individualArray = new int[] {0, 1, 2, 3};

    public Shelter(String id, String name, String capacity, String restriction, String longitude,
                   String latitude, String address, String notes, String number){
        this.id = id;
        if (name == null) {
            this.name = "N/A";
        } else{
            this.name = name;
        }
        this.name = name;
        if (capacity == null) {
            this.capacity = "N/A";
        } else{
            this.capacity = capacity;
        }
        this.restriction = restriction;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.notes = notes;
        this.number = number;
        capacityCheck();
        reserveFamily(0);
        reserveIndividual(0);
         if (!shelterList.contains(this)) {
             shelterList.add(this);
         }
        Log.e("myApp", "length is " + shelterList.size());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getRestriction() {
        return restriction;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getAddress() {
        return address;
    }

    public String getNotes() {
        return notes;
    }

    public String getNumber() {
        return number;
    }

    public int getFamily() {
        return family;
    }

    public int getIndividual() {
        return individual;
    }

    public static ArrayList<Shelter> getShelterList() {
        return shelterList;
    }

    public static void setShelterList(ArrayList l) {
        shelterList = l;
    }

    public boolean equals(Object o) {
        Shelter d = (Shelter) o;
        return this.name.equals(d.getName());
    }

    public String[] getFamilyArray() {
        String[] temp = new String[familyArray.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.toString(familyArray[i]);
        }
        return temp;
    }

    public String[] getIndividualArray() {
        String[] temp = new String[individualArray.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.toString(individualArray[i]);
        }
        return temp;
    }

    public static Shelter findShelter(String id) {
        return shelterList.get(Integer.parseInt(id));
    }

    private void capacityCheck() {
        if (capacity.equals("N/A")) {
            this.individual = 0;
            this.family = 0;
        } else if (capacity.length() < 4) {
            this.individual = Integer.parseInt(capacity);
        } else {
            String[] capacities = capacity.split(",");
            for (int i = 0; i < capacities.length; i++) {
                Log.e("myApp", "runs");
                String num = "";
                for (int j = 0; j < capacities[i].length(); j++) {
                    if (capacities[i].charAt(j) < 58 && capacities[i].charAt(j) > 47) {
                        num += capacities[i].charAt(j);
                    }
                }
                Log.e("numnum", "The array element is" + capacities[i]);

                Log.e("numnum", "The capacity is" + num);

                if (capacities[i].contains("fam") || capacities[i].contains("apart")) {
                    this.family = Integer.parseInt(num);
                } else if (capacities[i].contains("sing")) {
                    this.individual = Integer.parseInt(num);
                }
            }
        }
    }

    public void reserveFamily(int amount) {
        this.family -= amount;
        if (this.family < 4) {
            int[] temp = new int[family];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = i;
            }
            familyArray = temp;
        }
    }

    public void reserveIndividual(int amount) {
        this.individual -= amount;
        if (this.individual < 4) {
            int[] temp = new int[individual];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = i;
            }
            individualArray = temp;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(@NonNull Shelter o) {
        return this.getName().compareTo(o.getName());
    }
}