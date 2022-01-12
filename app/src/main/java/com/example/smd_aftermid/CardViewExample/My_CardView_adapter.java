package com.example.smd_aftermid.CardViewExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smd_aftermid.R;

import java.util.List;

public class My_CardView_adapter extends RecyclerView.Adapter<My_CardView_adapter.My_CardView_Holder>{

    public Context context;
    List<my_model> modelList;

    public My_CardView_adapter(Context context, List<my_model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public My_CardView_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card,parent,false);
        return new My_CardView_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull My_CardView_Holder holder, int position) {
        my_model myModel = modelList.get(position);
        holder.title.setText(myModel.getName());
        holder.count.setText( myModel.getThumbnail());
        Glide.with(context).load(myModel.getThumbnail()).into(holder.mycardimageview);
    }

    @Override
    public int getItemCount() {
        return modelList.size();

    }

    public class My_CardView_Holder extends RecyclerView.ViewHolder {

        TextView title,count;
        ImageView mycardimageview;

        public My_CardView_Holder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.my_cardtext1);
            count = view.findViewById(R.id.my_cardtext2);
            mycardimageview = view.findViewById(R.id.my_cardimage);
        }
    }
}
