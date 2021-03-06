package com.telpa.ecommerce.adapters;

import android.app.Activity;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.RatingBar;

import com.squareup.picasso.Picasso;
import com.telpa.ecommerce.R;
import com.telpa.ecommerce.models.Product;

import java.util.ArrayList;


/**
 * Created by volkan on 14.07.2016.
 */

public class RecyclerAdapter_I extends RecyclerView.Adapter<RecyclerAdapter_I.ViewHolder> {

    private int amountOfData;
    private int id;
    private ArrayList<Product> products;
    private Activity activity;

    public RecyclerAdapter_I(Activity activity, int amountOfData, int id, ArrayList<Product> products) {
        this.amountOfData = amountOfData;
        this.id = id;
        this.products = products;
        this.activity = activity;
    }

    @Override
    public RecyclerAdapter_I.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(id, parent, false);

        RecyclerAdapter_I.ViewHolder viewHolder = new RecyclerAdapter_I.ViewHolder(v);
        new SpaceItemDecoration(300);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.productName.setText(products.get(position).getName());
        holder.price.setText("$"+products.get(position).getPrice());
        holder.ratingBar.setRating(products.get(position).getRating());
        holder.description.setText(products.get(position).getDescripton());
        Picasso.with(activity).load(products.get(position).getHighResImageUrls().get(0)).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return amountOfData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productName;
        public TextView price;
        public TextView description;
        public ImageButton image;
        public RatingBar ratingBar;

        public ViewHolder(View v) {
            super(v);

            productName = (TextView) v.findViewById(R.id.productName);
            price = (TextView) v.findViewById(R.id.price);
            description = (TextView) v.findViewById(R.id.description);
            image = (ImageButton) v.findViewById(R.id.image);
            ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);
        }
    }

    public static class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        int space = 0;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;


        }
    }

}
