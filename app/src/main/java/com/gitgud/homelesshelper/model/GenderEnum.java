package com.gitgud.homelesshelper.model;

/**
 * Created by toddw on 3/12/2018.
 */

public enum GenderEnum {
    ANYONE ("Anyone"),
    MALE ("Male"),
    FEMALE ("Female");
    private final String text;
    GenderEnum(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
}
