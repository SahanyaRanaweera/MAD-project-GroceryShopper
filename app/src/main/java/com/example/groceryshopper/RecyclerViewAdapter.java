package com.example.groceryshopper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.groceryshopper.Model.DealsList;


public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "test.recyclerview.RecyclerViewAdapter";
    private DealsList[] deals;
    private Context mContext;

    public RecyclerViewAdapter(DealsList[] deals , Context mContext) {
        this.deals = deals;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list1,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        final DealsList dealsListData = deals[position];
        holder.category.setText(deals[position].getCategory());
        holder.name.setText(deals[position].getImgName());
        holder.price.setText(deals[position].getPrice());
        Glide.with(mContext)
                .asBitmap().load(deals[position].getImgUrl())
                .into(holder.image);
        holder.addtocart.setText("Add to Cart");
        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Added item: "+dealsListData.getImgName()+" to cart",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return deals.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView category;
        TextView name;
        TextView price;
        Button addtocart;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            category = itemView.findViewById(R.id.category);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            addtocart = itemView.findViewById(R.id.addtocart);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}