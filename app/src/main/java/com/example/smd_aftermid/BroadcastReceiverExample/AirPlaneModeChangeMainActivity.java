package com.example.smd_aftermid.BroadcastReceiverExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.smd_aftermid.R;

public class AirPlaneModeChangeMainActivity extends AppCompatActivity {

    MyAirPlaneModeReceiver obj = new MyAirPlaneModeReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_plane_mode_change_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(obj,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(obj);
    }
}