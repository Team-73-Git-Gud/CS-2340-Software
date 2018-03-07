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


import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.User;

public class RegisterActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

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

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, User.legalClassification);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classification.setAdapter(adapter);


    }

    private void attemptRegistration() {

        if ((User.isEnterableUsername(emailAddress.getText().toString())) && (User.isEnterablePassword(password.getText().toString())) && ! name.getText().toString().equals("name")) {
            User.setPassword(password.getText().toString());
            User.setUserName(emailAddress.getText().toString());
            User.setName(name.getText().toString());
            User.setClassification(classification.getSelectedItem().toString());
            if (name.getText().toString().equals("name")) {
                User.setName(name.getText().toString());
            }
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
           if (! User.isEnterablePassword(password.getText().toString())) {
               password.setText("Invalid Password");

           }
           if (! User.isEnterableUsername(emailAddress.getText().toString())){
               emailAddress.setText("Invalid Username");
           }
           if (name.getText().toString().equals("name")) {
               name.setText("Invalid Name");
           }

        }

    }
}
