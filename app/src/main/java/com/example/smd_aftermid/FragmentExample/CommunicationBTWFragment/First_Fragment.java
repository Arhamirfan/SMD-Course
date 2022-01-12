package com.example.smd_aftermid.FragmentExample.CommunicationBTWFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smd_aftermid.R;

public class First_Fragment extends Fragment {
    ButtonPressedListener.onbuttonpressed buttonPressedListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.first_fragment,container,false);
        mymessage(viewGroup);
        return viewGroup;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressedListener = (ButtonPressedListener.onbuttonpressed) getActivity();
    }

    void mymessage(ViewGroup viewGroup)
    {
        TextView textView= viewGroup.findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPressedListener.onbuttonPressed("Message from first fragment");
            }
        });
    }
}
