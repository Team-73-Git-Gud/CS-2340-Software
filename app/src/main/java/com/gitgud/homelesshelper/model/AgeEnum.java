package com.gitgud.homelesshelper.model;

/**
 * Created by toddw on 3/12/2018.
 */

public enum AgeEnum {
    NO_RESTRICTIONS ("No Restrictions"),
    ANYONE ("Anyone"),
    FAMILIES_AND_NEWBORNS ("Family/Newborn"),
    CHILDREN ("Children"),
    YOUNG_ADULTS ("Young Adults");
    private final String text;
    AgeEnum(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
}
