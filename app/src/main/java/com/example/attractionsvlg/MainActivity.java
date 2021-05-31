package com.example.attractionsvlg;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView ListViewAttractions;
    private ArrayList<Attraction> Attractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
        ListViewAttractions = findViewById(R.id.LIstViewAttractions);
        Attractions = new ArrayList<>();
        Attractions.add( new Attraction (getString(R.string.MamaevKurgan_title), getString(R.string.MamaevKurgan_info),
                R.drawable.mamaev));
        Attractions.add( new Attraction (getString(R.string.Museum_title), getString(R.string.Museum_info),
                R.drawable.museum));
        Attractions.add( new Attraction (getString(R.string.House_title), getString(R.string.House_info),
                R.drawable.house));
        Attractions.add( new Attraction (getString(R.string.Fontan_title), getString(R.string.Fontan_info),
                R.drawable.fontan));
        Attractions.add( new Attraction (getString(R.string.Sobor_title), getString(R.string.Sobor_info),
                R.drawable.sobor));

        ArrayAdapter<Attraction> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,Attractions);
        ListViewAttractions.setAdapter(adapter);

        ListViewAttractions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attraction attraction = Attractions.get(position);
              Intent intent = new Intent(getApplicationContext(), AttractionActivity.class);
              intent.putExtra("title", attraction.getTitle());
              intent.putExtra("info", attraction.getInfo());
              intent.putExtra("resId", attraction.getImageResourceId());
              startActivity(intent);
            }
        });
    }
}