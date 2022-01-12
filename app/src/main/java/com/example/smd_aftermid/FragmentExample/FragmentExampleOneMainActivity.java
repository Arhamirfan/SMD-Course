package com.example.smd_aftermid.FragmentExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.smd_aftermid.R;

public class FragmentExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_example_one_main);

        Configuration configuration = getResources().getConfiguration();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            PortraitModeFragment portraitModeFragment =new PortraitModeFragment();
            ft.replace(android.R.id.content,portraitModeFragment);
        }
        else{
            LandscapeModeFragment landscapeModeFragment = new LandscapeModeFragment();
            ft.replace(android.R.id.content,landscapeModeFragment);
        }
        ft.commit();
    }
}