package com.example.smd_aftermid.FirebaseExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.smd_aftermid.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseExampleOneMainActivity extends AppCompatActivity {
    FirebaseDatabase database= FirebaseDatabase.getInstance("https://smdsectiond-default-rtdb.firebaseio.com/");
    DatabaseReference myReference = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_example_one_main);

    }

    public void AddData(View view) {
        //myReference.setValue("Mustafa ALI is good boy");
        //myReference.child("SMD1").setValue("KUKR");
        myReference.child("SMD2").child("Section D").child("Student").child("ARHAM").child("Marks").setValue("69");
        myReference.child("SMD2").child("Section D").child("Student").child("Tariz").child("Marks").setValue("70");
        myReference.child("SMD2").child("Section D").child("Student").child("Pandey").child("Marks").setValue("96");
        myReference.child("SMD2").child("Section D").child("Student").child("Bunty").child("Marks").setValue("97");
        myReference.child("SMD2").child("Section D").child("Student").child("Pansota").child("Marks").setValue("98");

        Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
    }

    public void RemoveAllData(View view) {
        myReference.removeValue();
    }


    public void GetData(View view) {
        myReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //String value = snapshot.getValue().toString();
                //Toast.makeText(FirebaseExampleOneMainActivity.this, value+" ", Toast.LENGTH_SHORT).show();
                if(snapshot.getValue() !=null)
                {
                    for(DataSnapshot dataSnapshot : snapshot.getChildren())
                    {
                        String value = dataSnapshot.getValue().toString();
                        Log.d("TAG", "Firebase data : "+  value);
                    }
                }
                //Log.d("TAG", "onDataChange: ");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}