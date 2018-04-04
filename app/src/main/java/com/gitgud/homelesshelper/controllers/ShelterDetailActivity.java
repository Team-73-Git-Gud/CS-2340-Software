//package com.gitgud.homelesshelper.controllers;
//
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//import android.widget.TextView;
//
//import com.gitgud.homelesshelper.R;
//import com.gitgud.homelesshelper.model.Shelter;
//
//import org.w3c.dom.Text;
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
//
//        String id = getIntent().getStringExtra(Shelter.SHELTER_NAME);
//        Log.e("myApp", id);
//        Shelter shelter = null;
//        if (id != null) {
//            shelter = Shelter.findShelter(id);
//        }
//        name.setText(name.getText() + "  " + shelter.getName());
//        capacity.setText(capacity.getText() + "  " + shelter.getCapacity());
//        restriction.setText(restriction.getText() + "  " + shelter.getRestriction());
//        address.setText(address.getText() + "  " + shelter.getAddress());
//        longitude.setText(longitude.getText() + "  " + shelter.getLongitude());
//        latitude.setText(latitude.getText() + "  " + shelter.getLatitude());
//        number.setText(number.getText() + "  " + shelter.getNumber());
//        notes.setText(notes.getText() + "  " + shelter.getNotes());
//    }
//
//
//}
package com.gitgud.homelesshelper.controllers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.Shelter;
import com.gitgud.homelesshelper.model.User;
import com.gitgud.homelesshelper.model.UserAuthentication;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

import static com.gitgud.homelesshelper.model.Shelter.getShelterList;

public class ShelterDetailActivity extends AppCompatActivity {

    private TextView name;
    private TextView capacity;
    private TextView restriction;
    private TextView address;
    private TextView longitude;
    private TextView latitude;
    private TextView number;
    private TextView notes;
    private TextView family;
    private TextView individual;
    private Spinner familySpinner;
    private Spinner individualSpinner;
    private Button reserveButton;
    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.ShelterNameLabel);
        capacity = findViewById(R.id.ShelterCapacityLabel);
        restriction = findViewById(R.id.ShelterRestrictionLabel);
        address = findViewById(R.id.ShelterAddressLabel);
        longitude = findViewById(R.id.ShelterLongitude);
        latitude = findViewById(R.id.ShelterLatitude);
        number = findViewById(R.id.ShelterNumberLabel);
        notes = findViewById(R.id.ShelterNotesLabel);
        family = findViewById(R.id.ShelterFamily);
        individual = findViewById(R.id.ShelterSingles);
        familySpinner = (Spinner) findViewById(R.id.FamilySpinner);
        individualSpinner = (Spinner) findViewById(R.id.IndividualSpinner);
        reserveButton = findViewById(R.id.ReserveButton);

        String id = getIntent().getStringExtra(Shelter.SHELTER_NAME);
        Log.e("myApp", id);
        final Shelter shelter;
            shelter = Shelter.findShelter(id);

        final ArrayAdapter<String> familyAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Arrays.asList(shelter.getFamilyArray()));
        familyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familySpinner.setAdapter(familyAdapter);

        final ArrayAdapter<String> individualAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Arrays.asList(shelter.getIndividualArray()));
        individualAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        individualSpinner.setAdapter(individualAdapter);

        name.setText(name.getText() + "  " + shelter.getName());
        capacity.setText(capacity.getText() + "  " + shelter.getCapacity());
        restriction.setText(restriction.getText() + "  " + shelter.getRestriction());
        address.setText(address.getText() + "  " + shelter.getAddress());
        longitude.setText(longitude.getText() + "  " + shelter.getLongitude());
        latitude.setText(latitude.getText() + "  " + shelter.getLatitude());
        number.setText(number.getText() + "  " + shelter.getNumber());
        notes.setText(notes.getText() + "  " + shelter.getNotes());
        family.setText(family.getText() + "  " + shelter.getFamily());
        individual.setText(individual.getText() + "  " + shelter.getIndividual());
        reserveButton.setText((User.getCurrentUser().isHasReservation())? "Cancel Reservation": "Reserve");

        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!User.getCurrentUser().isHasReservation()) {
                    int familyReservations = Integer.parseInt((familySpinner.getSelectedItem() == null? "0":familySpinner.getSelectedItem().toString() ));
                    int individualReservations = Integer.parseInt((individualSpinner.getSelectedItem() == null? "0":individualSpinner.getSelectedItem().toString() ));
                    shelter.reserveIndividual(individualReservations);
                    shelter.reserveFamily(familyReservations);

                    family.setText("Family capacity " + shelter.getFamily());
                    individual.setText("Singles capacity " + shelter.getIndividual());
                    User.getCurrentUser().setShelterReserved(shelter.getId());
                    User.getCurrentUser().setHasReservation(true);
                    User.getCurrentUser().setNumFamilyReserved(familyReservations);
                    User.getCurrentUser().setNumIndividualReserved(individualReservations);

//                    ArrayList<User> userlist = UserAuthentication.getList();
//                    for (User use: userlist) {
//                        if (use.getname().equals(User.getCurrentUser().getname())) {
//                            use = User.getCurrentUser();
//                        }
//                    }

                    mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
                    Firebase mRef2 = mRef.child("Users");
                    Firebase mRefChild = mRef2.child(User.getCurrentUser().getpassWord());
                    mRefChild.setValue(User.getCurrentUser());

                    ArrayList<Shelter> list = getShelterList();
                    for (Shelter shell: list) {
                        if (shell.getName().equals(shelter.getName())) {
                            shell = shelter;

                        }
                    }
                    Shelter.setShelterList(list);
                    mRefChild = mRef.child("Shelter");
                    mRefChild.setValue(getShelterList());
                    reserveButton.setText((User.getCurrentUser().isHasReservation())? "Cancel Reservation": "Reserve");

                } else {
                    int familyReservations = User.getCurrentUser().getNumFamilyReserved() * -1;
                    int individualReservation = User.getCurrentUser().getNumIndividualReserved() * -1;
                    Shelter reservedShelter = Shelter.findShelter(User.getCurrentUser().getShelterReserved());
                    reservedShelter.reserveFamily(familyReservations);
                    reservedShelter.reserveIndividual(individualReservation);

                    family.setText("Family capacity " + shelter.getFamily());
                    individual.setText("Singles capacity " + shelter.getIndividual());
                    User.getCurrentUser().setHasReservation(false);
                    User.getCurrentUser().setNumFamilyReserved(0);
                    User.getCurrentUser().setNumIndividualReserved(0);
                    User.getCurrentUser().setShelterReserved("");
                    mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
                    Firebase mRef2 = mRef.child("Users");
                    Firebase mRefChild = mRef2.child(User.getCurrentUser().getpassWord());
                    mRefChild.setValue(User.getCurrentUser());

                    ArrayList<Shelter> list = getShelterList();
                    for (Shelter shell: list) {
                        if (shell.getName().equals(shelter.getName())) {
                            shell = shelter;

                        }
                    }
                    Shelter.setShelterList(list);
                    mRefChild = mRef.child("Shelter");

                    mRefChild.setValue(getShelterList());
                    reserveButton.setText((User.getCurrentUser().isHasReservation())? "Cancel Reservation": "Reserve");

                }
            }
        });
    }


    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            name.setVisibility(show ? View.GONE : View.VISIBLE);
            name.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    name.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            capacity.setVisibility(show ? View.VISIBLE : View.GONE);
            capacity.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    capacity.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            restriction.setVisibility(show ? View.GONE : View.VISIBLE);
            restriction.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    restriction.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            address.setVisibility(show ? View.VISIBLE : View.GONE);
            address.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    address.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            longitude.setVisibility(show ? View.GONE : View.VISIBLE);
            longitude.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    longitude.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            latitude.setVisibility(show ? View.VISIBLE : View.GONE);
            latitude.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    latitude.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            number.setVisibility(show ? View.VISIBLE : View.GONE);
            number.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    number.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            notes.setVisibility(show ? View.VISIBLE : View.GONE);
            notes.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    notes.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            family.setVisibility(show ? View.VISIBLE : View.GONE);
            family.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    family.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            individual.setVisibility(show ? View.VISIBLE : View.GONE);
            individual.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    individual.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            name.setVisibility(show ? View.VISIBLE : View.GONE);
            name.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}
