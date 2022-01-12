package com.example.smd_aftermid.FragmentExample.CommunicationBTWFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smd_aftermid.R;

public class Second_Fragment extends Fragment {
    TextView textView;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.first_fragment,container,false);
        return view;
    }

    public void onFragmentInteraction(String message)
    {
        textView = view.findViewById(R.id.text);
        textView.setText(message);
    }
}
