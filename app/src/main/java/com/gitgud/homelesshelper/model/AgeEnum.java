package com.gitgud.homelesshelper.model;

/**
 * Created by toddw on 3/12/2018.
 */

public enum AgeEnum {
    ANYONE ("Anyone"),
    FAMILYNEWBORN ("Family/Newborn"),
    CHILDREN ("Children"),
    YOUNGADULTS ("Young Adults");
    private final String text;
    AgeEnum(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
}
