package com.example.smd_aftermid.FragmentExample.ContactsAppExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smd_aftermid.R;

public class ContactDetailFragment extends Fragment {

    TextView contactsDetailView;
    int currentIndex = -1;
    int arrayLength;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contactdetails,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        contactsDetailView = getActivity().findViewById(R.id.contactdetailtextview);
        arrayLength = ContactsAppMainActivity.contactsArray.length;
    }

    public int getshownIndex()
    {
        return currentIndex;
    }
    public void contactIndex(int index)
    {
        if(index < 0 || index >= arrayLength)
        {
            return;
        }
        currentIndex = index;
        contactsDetailView.setText(ContactsAppMainActivity.contactsdetailArray[index]);
    }
}
