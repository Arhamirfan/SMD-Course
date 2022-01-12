package com.example.smd_aftermid.FragmentExample.CommunicationBTWFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.smd_aftermid.R;

public class CommunicationMainActivity extends FragmentActivity implements ButtonPressedListener.onbuttonpressed {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_main);
    }

    @Override
    public void onbuttonPressed(String message) {
        Second_Fragment obj = (Second_Fragment) getSupportFragmentManager().findFragmentById(R.id.frag02);
        obj.onFragmentInteraction(message);
    }
}