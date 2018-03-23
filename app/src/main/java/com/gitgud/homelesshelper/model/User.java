package com.gitgud.homelesshelper.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csaetei on 2/21/2018.
 */

public class User {

        private String emailAddress;
        private String userName;
        private String password;
        private String email;
        //private String id;
        private String Class;
        private String name;
        private boolean isBooked;




        public User(String email, String userName, String password, String name, String Class) {
            this.emailAddress = email;
            this.userName = userName;
            this.password = password;
            this.Class = Class;
            this.name = name;
            isBooked = false;
            //add to firebase here
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }

        public String getclass() {
            return Class;
        }

        public String getEmail() {
            return emailAddress;
        }

        public boolean getStatus() {
            return isBooked;
        }

        public void setStatus(Boolean boole) {
            isBooked = boole;
        }
}
