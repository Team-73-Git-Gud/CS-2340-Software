package com.gitgud.homelesshelper.controllers;

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

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.FirebaseDatabase;


import com.firebase.client.Firebase;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.FirebaseInterface;
import com.gitgud.homelesshelper.model.User;
import com.gitgud.homelesshelper.model.UserAuthentication;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class RegisterActivity extends AppCompatActivity {
    private Firebase mRef;

    private EditText emailAddress;
    private EditText password;
    private Button regButton;
    private Button backButton;
    private EditText name;
    private Spinner classification;
    private TextView type;

    private View mProgressView;
    private View mLoginFormView;

    private LoginActivity.UserLoginTask mAuthTask = null;

    final List<User> tempList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        FirebaseApp.initializeApp(this);

        Firebase.setAndroidContext(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();
        databaseReference.child("Users").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for(DataSnapshot child: children) {
                    if(child != null) {
                        User user = (User) child.getValue(User.class);
                        tempList.add(user);
                    }
                }
                UserAuthentication.setList((ArrayList<User>) tempList);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        emailAddress = (EditText) findViewById(R.id.EmailAddress);
        password = (EditText) findViewById(R.id.password);
        regButton = (Button) findViewById(R.id.registerButton);
        backButton = (Button) findViewById(R.id.backButton);
        name = (EditText) findViewById(R.id.name);
        classification = (Spinner) findViewById(R.id.classificationSpinner);
        type = (TextView) findViewById(R.id.textView2);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegistration();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, UserAuthentication.legalClassification);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classification.setAdapter(adapter);


    }

    private void attemptRegistration() {

        if ((UserAuthentication.isValidUser(emailAddress.getText().toString(), password.getText().toString())&& ! name.getText().toString().equals("name"))){

            Firebase.setAndroidContext(this);
            mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
            Firebase mRef2 = mRef.child("Users");

            User s = new User(emailAddress.getText().toString(), password.getText().toString(), name.getText().toString(), classification.getSelectedItem().toString());
            //FirebaseInterface.addUser(s);
            Firebase mRefChild = mRef2.child(s.getpassWord());
            mRefChild.setValue(s);



            //startActivity(new Intent(RegisterActivity.this, LoadingScreenActivity.class));
            emailAddress.setText("validated");
            name.setText("validated");
            password.setText("validated");

            if (emailAddress.getText().toString().equals("validated")
                    && name.getText().toString().equals("validated")
                    && password.getText().toString().equals("validated")) {
                finish();
            }


        } else {
           if (! UserAuthentication.isValidPassword(password.getText().toString())) {
               password.setText("Invalid Password");

           }
           if (! UserAuthentication.isValidUsername(emailAddress.getText().toString())){
               emailAddress.setText("Invalid Username");
           }
           if (name.getText().toString().equals("name")) {
               name.setText("Invalid Name");
           }

        }

    }
}
