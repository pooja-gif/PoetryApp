package com.example.poetryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PoetryAdapter extends RecyclerView.Adapter<PoetryAdapter.ViewHolder>{
//To set the data in recyclerview we have to take items :- Context (with its object), ListView (how to show the designed layout in a particular list form i.e recylerview)
//CreateViewholder here, we inflate the designed layout

    Context context;
List<PoetryModel> poetryModelList;

    public PoetryAdapter(Context context, List<PoetryModel> poetryModelList) {
        this.context = context;
        this.poetryModelList = poetryModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=  LayoutInflater.from(context).inflate(R.layout.poetry_design_list,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.poetName.setText(poetryModelList.get(position).getPoet_name());
holder.poetry.setText(poetryModelList.get(position).getPoetry_data());
holder.date_time.setText(poetryModelList.get(position).getDate_time());
    }

    @Override
    public int getItemCount() {
        return poetryModelList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView poetName, poetry, date_time;
        Button UpdateBtn, DeleteBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        poetName = itemView.findViewById(R.id.txt_poetName);
        poetry = itemView.findViewById(R.id.txt_poetryData);
        date_time =itemView.findViewById(R.id.txt_dateTime);
        UpdateBtn = itemView.findViewById(R.id.btn_update);
        DeleteBtn = itemView.findViewById(R.id.btn_delete);

        }
    }
}
