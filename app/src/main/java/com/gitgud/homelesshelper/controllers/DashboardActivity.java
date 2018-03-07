package com.gitgud.homelesshelper.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.CSVParser;
import com.gitgud.homelesshelper.model.User;

/**
 * Created by collin on 2/13/18.
 */

public class DashboardActivity extends AppCompatActivity{
    private Button logoutButton;
    private Button viewShelterButton;
    private  CSVParser stuff;
    private TextView type;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        type = (TextView) findViewById(R.id.textView3);
        type.setText(User.getClasss());
        name = (TextView) findViewById(R.id.textView4);
        name.setText(User.getName());

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

        stuff = new CSVParser(DashboardActivity.this);

    }
}
