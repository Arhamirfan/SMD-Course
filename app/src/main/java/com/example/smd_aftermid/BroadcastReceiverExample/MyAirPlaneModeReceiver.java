package com.example.smd_aftermid.BroadcastReceiverExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyAirPlaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(isAirPLaneModeChanged(context.getApplicationContext()))
        {
            Toast.makeText(context, "Airplane Mode is ON", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Airplane Mode is OFF", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isAirPLaneModeChanged(Context context)
    {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON,0) != 0;
    }
}
