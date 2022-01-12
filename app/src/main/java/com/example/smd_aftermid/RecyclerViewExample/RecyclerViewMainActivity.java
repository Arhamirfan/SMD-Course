package com.example.smd_aftermid.RecyclerViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.example.smd_aftermid.R;

import java.util.ArrayList;

public class RecyclerViewMainActivity extends AppCompatActivity {
    RecyclerView myrecyclerview;
    ArrayList<Mobiles> mobileList = new ArrayList<Mobiles>();
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        myrecyclerview = findViewById(R.id.myrecyclerview);
        adapter = new MyAdapter(mobileList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        myrecyclerview.setLayoutManager(layoutManager);
        myrecyclerview.setItemAnimator(new DefaultItemAnimator());
        myrecyclerview.setAdapter(adapter);
        FillMobileList();
    }

    public  void FillMobileList()
    {
        Mobiles mobiles;
        mobiles = new Mobiles("Iphone","Apple", "$2500");
        mobileList.add(mobiles);
        mobiles = new Mobiles("Flip 3","Samsung", "$2700");
        mobileList.add(mobiles);
        mobiles = new Mobiles("8 pro","1+", "$800");
        mobileList.add(mobiles);
        adapter.notifyDataSetChanged();
    }
}