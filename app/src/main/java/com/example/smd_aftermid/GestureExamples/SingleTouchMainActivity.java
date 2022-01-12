package com.example.smd_aftermid.GestureExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smd_aftermid.R;

public class SingleTouchMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SingleTouchView(this,null));
    }
}