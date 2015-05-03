package com.vit.explorevellore;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Krishna Kalubandi on 14-04-2015.
 */
public class CommonActivity extends ActionBarActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        TextView tvTitle = (TextView) findViewById(R.id.tvTitleOfLocation);
       // getSupportActionBarActionBar().setTitle(getIntent().getStringExtra("nameOfCaller"));
        tvTitle.setText(getIntent().getStringExtra("name"));
        TextView tvLoc = (TextView) findViewById(R.id.tvLocationDetails);
        tvLoc.setText("Address:" + getIntent().getStringExtra("loc"));
        TextView tvDistance = (TextView) findViewById(R.id.tvDistanceDetails);
        tvDistance.setText("Distance from VIT:" + getIntent().getStringExtra("distance"));
        TextView tvFare = (TextView) findViewById(R.id.tvFareDetails);
        tvFare.setText("Auto Fare from VIT:" + getIntent().getStringExtra("fare"));
        if(getIntent().hasExtra("phone"))
        {
            TextView tvPhone = (TextView) findViewById(R.id.tvPhoneDetails);
            tvPhone.setText("Phone:" + getIntent().getStringExtra("phone"));
        }
        if(getIntent().hasExtra("hours")){
            TextView tvHours = (TextView) findViewById(R.id.tvHourDetails);
            tvHours.setText("Open-Hours:" + getIntent().getStringExtra("hours"));
        }
    }
}
