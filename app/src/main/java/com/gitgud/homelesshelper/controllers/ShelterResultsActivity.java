package com.gitgud.homelesshelper.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.SearchProvider;
import com.gitgud.homelesshelper.model.Shelter;
import java.util.ArrayList;

public class ShelterResultsActivity extends AppCompatActivity {

    RecyclerView shelterRecycle1;
    private RecyclerView.LayoutManager layoutManager;
    private Button returnbutton;
    private Button searchmapbutton;
    private ArrayList<Shelter> list = SearchProvider.getSearchResult();
    private TextView nofound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_results);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        shelterRecycle1 = findViewById(R.id.ShelterListView);
        shelterRecycle1.setAdapter(new ShelterRecyclerViewAdapter(SearchProvider.getSearchResult()));

        returnbutton = findViewById(R.id.return_button);
        returnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        searchmapbutton = findViewById(R.id.viewsearchmapbutton);
        searchmapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShelterResultsActivity.this, SearchMapActivity.class));
            }
        });

        nofound = findViewById(R.id.textView7);
            /*
            if(list.size()==0) {
                nofound.setText("                      Sorry, nothing found.");
            }
            */

    }

    public class ShelterRecyclerViewAdapter extends RecyclerView.Adapter<ShelterRecyclerViewAdapter.ViewHolder> {

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

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View view;
            public final TextView shelterName;
            public Shelter shelter;

            public ViewHolder(View view) {
                super(view);
                this.view = view;
                this.shelterName = view.findViewById(R.id.name);
            }
        }

        public int getItemCount() {
            return shelterList.size();
        }


    }

}