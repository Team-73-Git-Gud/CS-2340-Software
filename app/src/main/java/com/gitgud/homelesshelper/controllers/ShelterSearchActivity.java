package com.gitgud.homelesshelper.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.AgeEnum;
import com.gitgud.homelesshelper.model.GenderEnum;
import com.gitgud.homelesshelper.model.SearchProvider;
import com.gitgud.homelesshelper.model.Shelter;

/**
 * Created by collin on 3/12/18.
 */

public class ShelterSearchActivity extends AppCompatActivity {


        //Widgets we will need for binding and getting information
     //*/
        private Button mBackB;
        private Button mSearchButton;
        private EditText mNameView;
        private Spinner mGenderView;
        private Spinner mAgeView;
    ///* ************************
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_search2);



        mNameView = (EditText)findViewById(R.id.nametextfield1);
        mGenderView = (Spinner)findViewById(R.id.genderspinner);
        mAgeView = (Spinner)findViewById(R.id.agespinner);
        mBackB =  findViewById(R.id.back_button);
        mSearchButton = findViewById(R.id.search_button);

        //populates the Gender spinner with the values of the enum class
        ArrayAdapter<GenderEnum> adapterclass = new ArrayAdapter(this,android.R.layout.simple_spinner_item, GenderEnum.values());
        adapterclass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGenderView.setAdapter(adapterclass);

        //populates the Age spinner with the values of the enum class
        ArrayAdapter<AgeEnum> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, AgeEnum.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAgeView.setAdapter(adapter);

        // Initialize login request on button press
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // tell search provider to search and store result
                SearchProvider.search(Shelter.getShelterList(), mNameView.getText().toString(), mGenderView.getSelectedItem().toString(), mAgeView.getSelectedItem().toString());
                finish();
            }
        });

        mBackB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }}

