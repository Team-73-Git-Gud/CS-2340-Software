package com.gitgud.homelesshelper.model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by csaet on 2/24/2018.
 */

public class Shelter {

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

    public Shelter(String id, String name, String capacity, String restriction, String longitude,
                   String latitude, String address, String notes, String number){
        this.id = id;
        if (name == null) {
            this.name = "N/a";
        } else{
            this.name = name;
        }
        this.name = name;
        if (capacity == null) {
            this.capacity = "N/a";
        } else{
            this.capacity = capacity;
        }
        this.restriction = restriction;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.notes = notes;
        this.number = number;
        shelterList.add(this);
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

    public static ArrayList<Shelter> getShelterList() {
        return shelterList;
    }

    public static Shelter findShelter(String id) {
        return shelterList.get(Integer.parseInt(id));
    }

    @Override
    public String toString() {
        return name;
    }
}