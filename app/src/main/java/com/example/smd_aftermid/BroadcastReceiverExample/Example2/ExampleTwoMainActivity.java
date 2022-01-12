package com.example.smd_aftermid.BroadcastReceiverExample.Example2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import com.example.smd_aftermid.R;

public class ExampleTwoMainActivity extends AppCompatActivity {

    ExampleTwoMyBroadcast receiverclass;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_two_main);

        receiverclass = new ExampleTwoMyBroadcast();
        String name = "com.example.smd_aftermid.BroadcastReceiverExample.Example2.SOME_CRICKET_ACTION";
        intentFilter = new IntentFilter(name);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiverclass,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiverclass);
    }

    public void findcaptainofCricketTeam(View view) {
        Intent intent = new Intent("com.example.smd_aftermid.BroadcastReceiverExample.Example2.SOME_CRICKET_ACTION");
        sendBroadcast(intent);
    }
}