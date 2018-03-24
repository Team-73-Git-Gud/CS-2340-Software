package com.gitgud.homelesshelper.model;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;


import com.firebase.client.Firebase;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.FirebaseInterface;
import com.gitgud.homelesshelper.model.User;
import com.gitgud.homelesshelper.model.UserAuthentication;

import java.util.ArrayList;

/**
 * Created by Mac on 3/23/2018.
 */

public class FirebaseInterface {




    //mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
    final static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference mRef = database.getReference("https://cs-2340-software.firebaseio.com/");


    //DatabaseReference usersRef = database.child("user");

    public static void addUser(User u){
        DatabaseReference mRefChild = mRef.child(u.getpassWord());
        mRefChild.setValue(u);
    }
}
