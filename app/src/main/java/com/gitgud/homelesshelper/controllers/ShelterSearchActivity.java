package com.gitgud.homelesshelper.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.AgeEnum;
import com.gitgud.homelesshelper.model.GenderEnum;

/**
 * Created by collin on 3/12/18.
 */

public class ShelterSearchActivity extends AppCompatActivity {


        //Widgets we will need for binding and getting information
     //*/
        Button mBackB;
        Button searchB;
        EditText mNameView;
        Spinner mGenderView;
        Spinner mAgeView;
    ///* ************************
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_search2);



        mNameView = (EditText)findViewById(R.id.nametextfield1);
        mGenderView = (Spinner)findViewById(R.id.genderspinner);
        mAgeView = (Spinner)findViewById(R.id.agespinner);
        mBackB =  findViewById(R.id.backbutton);
        searchB = findViewById(R.id.searchbutton);

        //populates the Gender spinner with the values of the enum class
        ArrayAdapter<GenderEnum> adapterclass = new ArrayAdapter(this,android.R.layout.simple_spinner_item, GenderEnum.values());
        adapterclass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGenderView.setAdapter(adapterclass);

        //populates the Age spinner with the values of the enum class
        ArrayAdapter<AgeEnum> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, AgeEnum.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAgeView.setAdapter(adapter);

        /*
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        // Initialize login request on button press
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        */
        mBackB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }}

