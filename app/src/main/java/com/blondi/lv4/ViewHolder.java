package com.blondi.lv4;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Enio on 12/31/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName, tvRating, tvPrice, tvDescription;
    private ImageView ivProductImage;

    public ViewHolder(View itemView) {
        super(itemView);

        tvName = (TextView) itemView.findViewById(R.id.tvProductName);
        tvRating = (TextView) itemView.findViewById(R.id.tvProductRating);
        tvPrice = (TextView) itemView.findViewById(R.id.tvProductPrice);
        tvDescription = (TextView) itemView.findViewById(R.id.tvProductDescription);
        ivProductImage= (ImageView) itemView.findViewById(R.id.ivProduct);
    }


        public void setCell(Product product){

        tvName.setText(product.getName());


        tvRating.setText(Float.toString(product.getRating()));



        tvPrice.setText(product.getPrice());


        tvDescription.setText(product.getDescription().replace("\n", " ").replace("\t", " "));


        Picasso.get().load(product.getImageLink()).into(ivProductImage);

        }


}

