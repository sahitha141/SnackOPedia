package com.example.myapplication11111;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BDMyAdapter extends   RecyclerView.Adapter<BDMyAdapter.MyViewHolder>{
//public Object startL;
       Context context;

        ArrayList<modelBdetails> list;



public BDMyAdapter(Context context, ArrayList<modelBdetails> list) {
        this.context = context;
        this.list = list;

        }



@NonNull
@Override
public BDMyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_food_display,parent,false);
        return  new MyViewHolder(v);
        }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
       modelBdetails modelBdetails=list.get(position);
        holder.text.setText(modelBdetails.getTitle());
        holder.price.setText(modelBdetails.getPrice());


        Glide.with(context).load(list.get(position).getImage()).into(holder.image);
        Log.i("image",list.get(position).image);

    }

    @Override
public int getItemCount() {
        return list.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView text, price;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
             image=itemView.findViewById(R.id.idlivada);
            text=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);


            }
        }
}



