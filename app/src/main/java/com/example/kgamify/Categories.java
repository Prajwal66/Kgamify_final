package com.example.kgamify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        getSupportActionBar().hide();        //Code to remove Action Bar
    }
}