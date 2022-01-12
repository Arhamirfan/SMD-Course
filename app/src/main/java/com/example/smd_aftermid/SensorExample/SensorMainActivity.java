package com.example.smd_aftermid.SensorExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smd_aftermid.R;

public class SensorMainActivity extends AppCompatActivity implements SensorEventListener {
    ConstraintLayout constraintLayout;
    SensorManager sensorManager;
    boolean color=false;
    View view;
    long lastTimeUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_main);
        view = findViewById(R.id.sensorTextView);
        constraintLayout = findViewById(R.id.constraint);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    public void getMyAccelerometerValues(SensorEvent sensorEvent)
    {
        float[] values = sensorEvent.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        float acceleration = (x * x + y * y + z * z) / (sensorManager.GRAVITY_EARTH * sensorManager.GRAVITY_EARTH);
        long actualtime = sensorEvent.timestamp;
        if(acceleration >= 2)
        {
            if(actualtime - lastTimeUpdate < 150)
            {
                return;
            }
            lastTimeUpdate = actualtime;
            Toast.makeText(this, "Maaaa kiiiii chuuuhhhhhh", Toast.LENGTH_SHORT).show();
//            constraintLayout.setBackgroundColor(Color.GREEN);
            getWindow().getDecorView().setBackgroundColor(Color.GRAY);
            view.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            getMyAccelerometerValues(sensorEvent);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),sensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}