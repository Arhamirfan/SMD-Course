package com.example.smd_aftermid.ServiceExamples.BoundServiceExample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import com.example.smd_aftermid.R;

public class MyBoundServiceExampleOne extends Service {
    public MyBoundServiceExampleOne() {
    }

    MyBinder myBinder = new MyBinder();
    public MediaPlayer mediaPlayer;


    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.pinjra);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return  myBinder;
    }

    public  void play()
    {
        mediaPlayer.start();
    }
    public void pause()
    {
        mediaPlayer.pause();
    }
    public boolean isplaying()
    {
        return mediaPlayer.isPlaying();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    public class MyBinder extends Binder
    {
        MyBoundServiceExampleOne getServiceMethod()
        {
            return MyBoundServiceExampleOne.this;
        }
    }
}