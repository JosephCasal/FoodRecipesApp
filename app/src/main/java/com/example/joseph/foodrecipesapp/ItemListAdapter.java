package com.example.joseph.foodrecipesapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.joseph.foodrecipesapp.model.Hit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 10/27/17.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    private static final String TAG = "ItemListAd";
    List<Hit> hitList = new ArrayList<>();
    Context context;

    public ItemListAdapter(List<Hit> hitList) {
        this.hitList = hitList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Hit item = hitList.get(position);
        holder.item = item;

        Log.d(TAG, "onBindViewHolder: " + item.getRecipe().getImage());
        Glide.with(context).load(item.getRecipe().getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return hitList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        Hit item;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, RecipeActivity.class);
                    intent.putExtra("recipe", item);
                    context.startActivity(intent);
                }
            });
        }
    }
}
