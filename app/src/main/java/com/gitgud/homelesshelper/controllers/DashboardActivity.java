package com.gitgud.homelesshelper.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.CSVParser;
import com.gitgud.homelesshelper.model.Shelter;
import com.gitgud.homelesshelper.model.User;

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
import java.util.Random;
import com.google.firebase.database.FirebaseDatabase;

import static com.gitgud.homelesshelper.controllers.LoginActivity.currentUser;

/**
 * Created by collin on 2/13/18.
 */

public class DashboardActivity extends AppCompatActivity{
    private Button logoutButton;
    private Button viewShelterButton;
    private Button viewSearchButton;
    private  CSVParser stuff;
    private TextView type;
    private TextView name;

    //Database Stuff
    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //Database Stuff
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://cs-2340-software.firebaseio.com/");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        type = (TextView) findViewById(R.id.textView3);
        type.setText(currentUser.getclasss());
        name = (TextView) findViewById(R.id.textView4);
        name.setText(currentUser.getname());

        logoutButton = (Button) findViewById(R.id.buttonLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        viewShelterButton = (Button) findViewById(R.id.buttonViewShelter);
        viewShelterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, ShelterViewActivity.class));
            }
        });

        viewSearchButton = (Button)findViewById(R.id.gotosearch);
        viewSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, ShelterSearchActivity.class));
            }
        });

        stuff = new CSVParser(DashboardActivity.this);
        Firebase mRefChild = mRef.child("Shelter");
        mRefChild.setValue(Shelter.getShelterList());
    }
}
