package com.example.smd_aftermid.CardViewExample;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import com.bumptech.glide.load.engine.Resource;
import com.example.smd_aftermid.databinding.ActivityScrollingMainBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;


import com.example.smd_aftermid.R;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivityMain extends AppCompatActivity {

    public List<my_model> my_modelList;
    public My_CardView_adapter my_cardView_adapter;
    public RecyclerView recyclerView;

    private ActivityScrollingMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        recyclerView = findViewById(R.id.mycardviewrecycler);
        my_modelList = new ArrayList<>();
        my_cardView_adapter = new My_CardView_adapter(this,my_modelList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpace(2,10,true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(my_cardView_adapter);

        Insert();

    }
    public  class GridSpace extends RecyclerView.ItemDecoration
    {
        int count,spacing;
        boolean edgeInclude;

        public GridSpace(int count, int spacing, boolean edgeInclude) {
            this.count = count;
            this.spacing = spacing;
            this.edgeInclude = edgeInclude;
        }


        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int itemPosition = parent.getChildAdapterPosition(view);
            int itemColumn = itemPosition % count;
            if (edgeInclude)
            {
                outRect.left = spacing - itemColumn * spacing/count;
                outRect.right = (itemColumn + 1) * spacing / count;
                if (itemPosition < count )
                {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            }
        }
    }

    public void Insert()
    {
        int[] myImages = new int[]
                {
                  R.drawable.aaahh,R.drawable.likeserious,R.drawable.aaahh,R.drawable.likeserious,R.drawable.aaahh,R.drawable.likeserious
                };
        my_model myModel = new my_model("My First CardViewitem",10,myImages[0]);
        my_modelList.add(myModel);
        myModel = new my_model("My Second CardViewitem",100,myImages[1]);
        my_modelList.add(myModel);
        myModel = new my_model("My third CardViewitem",50,myImages[2]);
        my_modelList.add(myModel);
        myModel = new my_model("My forth CardViewitem",20,myImages[3]);
        my_modelList.add(myModel);
        myModel = new my_model("My fifth CardViewitem",70,myImages[4]);
        my_modelList.add(myModel);
        myModel = new my_model("My Sixtg CardViewitem",30,myImages[5]);
        my_modelList.add(myModel);

    }
}