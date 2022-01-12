package com.example.smd_aftermid.ServiceExamples.BoundServiceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.example.smd_aftermid.R;

public class BoundServiceExampleOneMainActivity extends AppCompatActivity {
    MyBoundServiceExampleOne myMediaPlayerService;
    public boolean myBoundService = false;
    public ServiceConnection myServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundServiceExampleOne.MyBinder myBinder = (MyBoundServiceExampleOne.MyBinder) iBinder;
            myMediaPlayerService = myBinder.getServiceMethod();
            myBoundService=true;
        }


        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service_example_one_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,MyBoundServiceExampleOne.class);
        bindService(intent,myServiceConnection,BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (myBoundService == true)
        {
            unbindService(myServiceConnection);
        }
    }

    public void playPause(View view) {
        if (myBoundService == true)
        {
            if (myMediaPlayerService.isplaying())
            {
                myMediaPlayerService.pause();
            }
            myMediaPlayerService.play();
        }
    }
}