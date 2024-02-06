package com.example.exc1_recycleviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<DataModel> dataset;
    public CustomAdapter(ArrayList<DataModel> dataSet) {
        this.dataset = dataSet;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageView;
        public MyViewHolder (View itemView){
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView);
            textViewVersion = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout , parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageView;
        textViewName.setText(dataset.get(position).getName());
        textViewVersion.setText((dataset.get(position).getVersion()));
        imageView.setImageResource(dataset.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

//Create recycle view for favortie tv show , each line is picture and two text ( 1.name of charecter,2.summery on charecter)  about 10 charecters (lines) , the head of the list - name of the tv show (first line)
