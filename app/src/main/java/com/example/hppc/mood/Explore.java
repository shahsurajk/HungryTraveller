package com.example.hppc.mood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Explore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        getIntent();
    }
}
