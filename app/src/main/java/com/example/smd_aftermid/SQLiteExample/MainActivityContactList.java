package com.example.smd_aftermid.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.smd_aftermid.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivityContactList extends AppCompatActivity {
    DbTools dbTools;
    ListView listView;
    TextView contactID;
    ArrayList<HashMap<String,String>> contactlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contact_list);

        listView = findViewById(R.id.listmainactivitycontactlist);
        dbTools = new DbTools(getApplicationContext());
        contactlist = dbTools.getAllContacts();
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,contactlist,R.layout.activity_contact_entery,new String[]{"_id","firstName","secondName"},
                new int[] {R.id.textViewID,R.id.textViewFirstName,R.id.textViewLastName}
                );
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //contactID = findViewById(R.id.textViewID);
                Intent intent = new Intent(MainActivityContactList.this,EditContactEntery.class);
                intent.putExtra("_id",String.valueOf(position+1));
                intent.putExtra("_id",String.valueOf(contactlist.get(position).get("_id")));
                startActivity(intent);
            }
        });
    }

    public void AddContact(View view) {
        Intent intent = new Intent(MainActivityContactList.this,NewContactActivity.class);
        startActivity(intent);
    }
}