package com.example.smd_aftermid.BroadcastReceiverExample.Example2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class ExampleTwoMyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String name = "com.example.smd_aftermid.BroadcastReceiverExample.Example2.SOME_CRICKET_ACTION";
        if(intent.getAction().equals(name))
        {
            Toast.makeText(context, "Some action is received", Toast.LENGTH_SHORT).show();
        }
        else
        {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
            if(isConnected)
            {
                Toast.makeText(context, "Connected with cricket ground", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(context, "Network is changed or demoted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
