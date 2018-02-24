package com.gitgud.homelesshelper.controllers;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gitgud.homelesshelper.R;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailAddress;
    private EditText password;
    private Button regButton;
    private Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        emailAddress = (EditText) findViewById(R.id.EmailAddress);
        password = (EditText) findViewById(R.id.password);
        regButton = (Button) findViewById(R.id.registerButton);
        backButton = (Button) findViewById(R.id.backButton);

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


    }

    private void attemptRegistration() {

    //mess with user class and put data into it and database.

    }




}
