package com.gitgud.homelesshelper.controllers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.Shelter;

import org.w3c.dom.Text;

public class ShelterDetailActivity extends AppCompatActivity {

    private TextView name;
    private TextView capacity;
    private TextView restriction;
    private TextView address;
    private TextView longitude;
    private TextView latitude;
    private TextView number;
    private TextView notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        name = findViewById(R.id.ShelterNameLabel);
        capacity = findViewById(R.id.ShelterCapacityLabel);
        restriction = findViewById(R.id.ShelterRestrictionLabel);
        address = findViewById(R.id.ShelterAddressLabel);
        longitude = findViewById(R.id.ShelterLongitude);
        latitude = findViewById(R.id.ShelterLatitude);
        number = findViewById(R.id.ShelterNumberLabel);
        notes = findViewById(R.id.ShelterNotesLabel);

        String id = getIntent().getStringExtra(Shelter.SHELTER_NAME);
        Log.e("myApp", id);
        Shelter shelter = null;
        if (id != null) {
            shelter = Shelter.findShelter(id);
        }
        name.setText(name.getText() + "  " + shelter.getName());
        capacity.setText(capacity.getText() + "  " + shelter.getCapacity());
        restriction.setText(restriction.getText() + "  " + shelter.getRestriction());
        address.setText(address.getText() + "  " + shelter.getAddress());
        longitude.setText(longitude.getText() + "  " + shelter.getLongitude());
        latitude.setText(latitude.getText() + "  " + shelter.getLatitude());
        number.setText(number.getText() + "  " + shelter.getNumber());
        notes.setText(notes.getText() + "  " + shelter.getNotes());
    }


}
//package com.gitgud.homelesshelper.controllers;
//
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import com.gitgud.homelesshelper.R;
//import com.gitgud.homelesshelper.model.Shelter;
//
//import org.w3c.dom.Text;
//
//import java.util.Arrays;
//
//public class ShelterDetailActivity extends AppCompatActivity {
//
//    private TextView name;
//    private TextView capacity;
//    private TextView restriction;
//    private TextView address;
//    private TextView longitude;
//    private TextView latitude;
//    private TextView number;
//    private TextView notes;
//    private TextView family;
//    private TextView individual;
//    private Spinner familySpinner;
//    private Spinner individualSpinner;
//    private Button reserveButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shelter_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        name = findViewById(R.id.ShelterNameLabel);
//        capacity = findViewById(R.id.ShelterCapacityLabel);
//        restriction = findViewById(R.id.ShelterRestrictionLabel);
//        address = findViewById(R.id.ShelterAddressLabel);
//        longitude = findViewById(R.id.ShelterLongitude);
//        latitude = findViewById(R.id.ShelterLatitude);
//        number = findViewById(R.id.ShelterNumberLabel);
//        notes = findViewById(R.id.ShelterNotesLabel);
//        family = findViewById(R.id.ShelterFamily);
//        individual = findViewById(R.id.ShelterSingles);
//        familySpinner = (Spinner) findViewById(R.id.FamilySpinner);
//        individualSpinner = (Spinner) findViewById(R.id.IndividualSpinner);
//        //reserveButton = findViewById(R.id.ReserveButton);
//
//        String id = getIntent().getStringExtra(Shelter.SHELTER_NAME);
//        Log.e("myApp", id);
//        Shelter shelter = null;
//        if (id != null) {
//            shelter = Shelter.findShelter(id);
//        }
//
//        ArrayAdapter<String> familyAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Arrays.asList(shelter.getFamilyArray()));
//        familyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        familySpinner.setAdapter(familyAdapter);
//
//        ArrayAdapter<String> individualAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Arrays.asList(shelter.getIndividualArray()));
//        individualAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        individualSpinner.setAdapter(individualAdapter);
//
//        name.setText(name.getText() + "  " + shelter.getName());
//        capacity.setText(capacity.getText() + "  " + shelter.getCapacity());
//        restriction.setText(restriction.getText() + "  " + shelter.getRestriction());
//        address.setText(address.getText() + "  " + shelter.getAddress());
//        longitude.setText(longitude.getText() + "  " + shelter.getLongitude());
//        latitude.setText(latitude.getText() + "  " + shelter.getLatitude());
//        number.setText(number.getText() + "  " + shelter.getNumber());
//        notes.setText(notes.getText() + "  " + shelter.getNotes());
//        family.setText(family.getText() + "  " + shelter.getFamily());
//        individual.setText(individual.getText() + "  " + shelter.getIndividual());
//    }
//
//
//}
