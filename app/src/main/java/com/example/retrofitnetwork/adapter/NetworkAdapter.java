package com.example.retrofitnetwork.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitnetwork.R;
import com.example.retrofitnetwork.model.Animal;

import java.util.List;

public class NetworkAdapter extends BaseAdapter {
    public List<Animal> animalList;
    public Context context;

    public NetworkAdapter(List<Animal> animalList, Context context) {
        this.animalList = animalList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return animalList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint({"ViewHolder", "InflateParams"})
        View view= LayoutInflater.from(context).inflate(R.layout.row_item,null);

        TextView name=view.findViewById(R.id.textView);
        ImageView image=view.findViewById(R.id.imageView);

        // set data
        name.setText(animalList.get(position).getName());

        // set image
        Glide.with(context).load(animalList.get(position).getLink()).into(image);
        return view;
    }
}
