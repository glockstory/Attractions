package com.example.attractionsvlg;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionActivity extends AppCompatActivity {
    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewAttraction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageViewAttraction = findViewById(R.id.imageViewAttraction);
        Intent intent = getIntent();
        if(intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")){
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId",-1);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewAttraction.setImageResource(resId);
        } else {
            Intent backToTheCategory = new Intent(this, AttractionActivity.class);
            startActivity(backToTheCategory);
        }

    }
}