package com.example.hppc.mood.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hppc.mood.Activity_Tabs;
import com.example.hppc.mood.Location.TrackGPS;
import com.example.hppc.mood.R;
import com.example.hppc.mood.storage.PreferenceManager;

public class LocationActivity extends AppCompatActivity {
    private AppCompatButton b_get;
    private TrackGPS gps;
    double longitude;
    double latitude;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location2);
        b_get = (AppCompatButton) findViewById(R.id.get);
        Spinner spinner = (Spinner) findViewById(R.id.al2_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.location, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        preferenceManager = PreferenceManager.getInstance();
        checkIfLocationExitsAndProceed();
        b_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gps = new TrackGPS(LocationActivity.this);


                if(gps.canGetLocation()){


                    longitude = gps.getLongitude();
                    latitude = gps .getLatitude();

                    preferenceManager.setLatLong(String.valueOf(latitude),String.valueOf(longitude));

                    startActivity(new Intent(LocationActivity.this, Activity_Tabs.class));
                    finish();
                    Toast.makeText(getApplicationContext(),"Longitude:"+Double.toString(longitude)+"\nLatitude:"+Double.toString(latitude),Toast.LENGTH_SHORT).show();
                }
                else
                {

                    gps.showSettingsAlert();
                }

            }
        });
    }

    private void checkIfLocationExitsAndProceed() {
        if (!TextUtils.isEmpty(preferenceManager.getCityName()) || preferenceManager.getLatLong().length!=0){
            startActivity(new Intent(LocationActivity.this,Activity_Tabs.class));
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        if (gps!=null)
            gps.stopUsingGPS();
        super.onDestroy();
    }
}

