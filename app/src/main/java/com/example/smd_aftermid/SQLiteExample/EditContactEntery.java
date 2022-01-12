package com.example.smd_aftermid.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.smd_aftermid.R;

import java.util.HashMap;

public class EditContactEntery extends AppCompatActivity {
    DbTools dbTools;
    EditText firstName,secondName,phoneNumber,emailAddress,homeAddress;
    Button update_btn, delete_btn;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact_entery);

        firstName = findViewById(R.id.editfirstname);
        secondName = findViewById(R.id.editsecondname);
        phoneNumber = findViewById(R.id.editphonenumber);
        emailAddress = findViewById(R.id.editemail);
        homeAddress = findViewById(R.id.edithomeaddress);
        update_btn = findViewById(R.id.button9);
        delete_btn = findViewById(R.id.button10);
        dbTools = new DbTools(getApplicationContext());

        Intent intent = getIntent();
        id = intent.getStringExtra("_id");

        HashMap<String,String> singlecontact = dbTools.getSingleRecord(id);
        if(singlecontact.size()!=0)
        {
            firstName.setText(singlecontact.get("firstName"));
            secondName.setText(singlecontact.get("secondName"));
            phoneNumber.setText(singlecontact.get("phoneNumber"));
            emailAddress.setText(singlecontact.get("emailAddress"));
            homeAddress.setText(singlecontact.get("homeAddress"));
        }
    }

    public void updatedata(View view) {
        HashMap<String,String> contact = new HashMap<String,String>();
        contact.put("_id",id);
        contact.put("firstName",firstName.getText().toString());
        contact.put("secondName",secondName.getText().toString());
        contact.put("phoneNumber",phoneNumber.getText().toString());
        contact.put("emailAddress",emailAddress.getText().toString());
        contact.put("homeAddress",homeAddress.getText().toString());
        dbTools.UpdateContact(contact,id);
        startActivity(new Intent(this,MainActivityContactList.class));
    }

    public void deletedata(View view) {
        dbTools.DeleteContact(id);
        startActivity(new Intent(this,MainActivityContactList.class));
    }
}