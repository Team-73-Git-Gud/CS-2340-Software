package com.gitgud.homelesshelper.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.SearchProvider;
import com.gitgud.homelesshelper.model.Shelter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class ShelterViewActivity extends AppCompatActivity {

    RecyclerView shelterRecycle;
    private RecyclerView.LayoutManager layoutManager;

    private Button mSearchButton;
    private Button mMapButton;

    private ArrayList<Shelter> list = Shelter.getShelterList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        shelterRecycle = (RecyclerView) findViewById(R.id.ShelterListView);
        final ShelterRecyclerViewAdapter shelterAdapter = new ShelterRecyclerViewAdapter(list);
        shelterRecycle.setAdapter(shelterAdapter);

        mSearchButton = findViewById(R.id.search_activity_button);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShelterViewActivity.this, ShelterSearchActivity.class));
                list = SearchProvider.getSearchResult();
                shelterAdapter.notifyDataSetChanged();
            }
        });

        mMapButton = findViewById(R.id.viewmapbutton);
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShelterViewActivity.this, DefaultMapActivity.class));
            }
        });

    }

    public class ShelterRecyclerViewAdapter extends RecyclerView.Adapter<ShelterRecyclerViewAdapter.ViewHolder> {

        public void updateData(ArrayList<Shelter> list) {
            shelterList = list;
            notifyDataSetChanged();
        }

        private ArrayList<Shelter> shelterList;

        public ShelterRecyclerViewAdapter(ArrayList<Shelter> shelterList) {
            this.shelterList = shelterList;
        }
        @Override
        public ShelterRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int index) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.shelter_detail, parent, false);

            return new ViewHolder(v);
        }

        public void onBindViewHolder(final ViewHolder holder, int position) {

            holder.shelter = shelterList.get(position);
            //Log.e("myApp", "contains null " + String.valueOf(shelterList.get(position).getCapacity().contains("null")));

            holder.shelterName.setText(shelterList.get(position).getName());

            holder.shelterName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //on a phone, we need to change windows to the detail view
                    Context context = v.getContext();
                    //create our new intent with the new screen (activity)
                    Intent intent = new Intent(context, ShelterDetailActivity.class);
                        /*
                            pass along the id of the course so we can retrieve the correct data in
                            the next window
                         */
                    intent.putExtra(Shelter.SHELTER_NAME, holder.shelter.getId());


                    //now just display the new window
                    context.startActivity(intent);

                }
            });


        }

        public void updates(ArrayList<Shelter> input)
        {
            if(input == null || input.size()==0)
                return;
            if (shelterList != null && shelterList.size()>0)
                shelterList.clear();
            shelterList.addAll(input);
            Collections.sort(shelterList);
            notifyDataSetChanged();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View view;
            public final TextView shelterName;
            public Shelter shelter;

            public ViewHolder(View view) {
                super(view);
                this.view = view;
                this.shelterName = (TextView) view.findViewById(R.id.name);
            }
        }

        public int getItemCount() {
            return shelterList.size();
        }


    }

}

