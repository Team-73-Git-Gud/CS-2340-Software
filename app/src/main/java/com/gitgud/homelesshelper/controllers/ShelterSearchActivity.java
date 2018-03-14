package com.gitgud.homelesshelper.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.AgeEnum;
import com.gitgud.homelesshelper.model.GenderEnum;
import com.gitgud.homelesshelper.model.SearchProvider;
import com.gitgud.homelesshelper.model.Shelter;

import java.util.ArrayList;

/**
 * Created by collin on 3/12/18.
 */

public class ShelterSearchActivity extends AppCompatActivity {


    //Widgets we will need for binding and getting information
    private Button mBackButton;
    private Button mSearchButton;
    private EditText mNameView;
    private Spinner mGenderView;
    private Spinner mAgeView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_search2);

        mNameView = (EditText)findViewById(R.id.name_text_field);
        mGenderView = (Spinner)findViewById(R.id.gender_spinner);
        mAgeView = (Spinner)findViewById(R.id.age_spinner);
        mBackButton = findViewById(R.id.back_button);
        mSearchButton = findViewById(R.id.search_button);

        //populates the Gender spinner with the values of the enum class
        ArrayAdapter<GenderEnum> genderAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, GenderEnum.values());
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGenderView.setAdapter(genderAdapter);

        //populates the Age spinner with the values of the enum class
        ArrayAdapter<AgeEnum> ageAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, AgeEnum.values());
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAgeView.setAdapter(ageAdapter);


        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // tell search provider to search and store result
                //(mGenderView.getSelectedItem())
                Log.d("PARA", "--------------------");
                Log.d("PARA", mNameView.getText().toString());
                Log.d("PARA", mGenderView.getSelectedItem().toString());
                Log.d("PARA", mAgeView.getSelectedItem().toString());
                SearchProvider.search(Shelter.getShelterList(), mNameView.getText().toString(),mGenderView.getSelectedItem().toString(), mAgeView.getSelectedItem().toString());
                startActivity(new Intent(ShelterSearchActivity.this, ShelterResultsActivity.class));
            }
        });

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

