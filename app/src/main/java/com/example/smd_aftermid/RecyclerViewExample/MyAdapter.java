package com.example.smd_aftermid.RecyclerViewExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smd_aftermid.R;

import java.util.ArrayList;

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.myViewHolder>{
    private ArrayList<Mobiles> mobilelist;

    public MyAdapter(ArrayList<Mobiles> mobilelist) {
        this.mobilelist = mobilelist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobilerow,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Mobiles mobiles = mobilelist.get(position);
        holder.mobilename.setText(mobiles.name);
        holder.mobilecompany.setText(mobiles.company);
        holder.mobileprice.setText(mobiles.price);
    }

    @Override
    public int getItemCount() {
        return mobilelist.size();
    }




    public class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView mobilename,mobilecompany,mobileprice;

        public myViewHolder(@NonNull View view) {
            super(view);
            mobilename = view.findViewById(R.id.txtmobilename);
            mobilecompany = view.findViewById(R.id.txtcompany);
            mobileprice = view.findViewById(R.id.txtprice);
        }
    }
}
