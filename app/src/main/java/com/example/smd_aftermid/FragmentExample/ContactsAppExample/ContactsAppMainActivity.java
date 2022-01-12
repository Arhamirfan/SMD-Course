package com.example.smd_aftermid.FragmentExample.ContactsAppExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smd_aftermid.R;

public class ContactsAppMainActivity extends AppCompatActivity implements ContactsFragment.ListSelectionListener{

    public static String[] contactsArray;
    public static String[] contactsdetailArray;
    ContactDetailFragment contactsdetailFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_app_main);

        contactsArray = getResources().getStringArray(R.array.contacts);
        contactsdetailArray = getResources().getStringArray(R.array.contactsdetails);
        contactsdetailFragment = (ContactDetailFragment) getSupportFragmentManager().findFragmentById(R.id.contactsdetailfragment);


    }

    @Override
    public void onSelectionList(int position) {
        if(contactsdetailFragment.getshownIndex() != position)
        {
            contactsdetailFragment.contactIndex(position);
        }
    }
}