package com.example.smd_aftermid.ServiceExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smd_aftermid.R;

public class ServiceExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example_one_main);

    }

    public void startService(View view) {
        Intent intent = new Intent(this,MyServiceExampleOne.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this,MyServiceExampleOne.class);
        stopService(intent);
    }
}