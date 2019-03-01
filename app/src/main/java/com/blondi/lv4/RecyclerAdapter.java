package com.blondi.lv4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enio on 12/31/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<Product> Products = new ArrayList<>();

    public RecyclerAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.Products = productList;
    }
    public void setProducts(List<Product> productList) {
        this.Products = productList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cell_product,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setCell(Products.get(position));
    }

    @Override
    public int getItemCount() {
        if (Products!=null)
        {return Products.size();}
        return 0;
    }
}
