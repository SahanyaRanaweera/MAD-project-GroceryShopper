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
import com.example.groceryshopper.Database.DBHelperShopCart;
import com.example.groceryshopper.Model.CartModel;
import com.example.groceryshopper.Model.DealsList;
import com.example.groceryshopper.Model.Item;


public class RecyclerViewAdapter1 extends
        RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {
    private static final String TAG = "test.recyclerview.RecyclerViewAdapter1";
    private Item[] items;
    CartModel cart;
    private Context mContext;

    public RecyclerViewAdapter1(Item[] items , Context mContext) {
        this.items = items;
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
        final Item itemListData = items[position];
        cart = new CartModel(itemListData.getImgName(), itemListData.getPrice(),CategoryActivity.userN);
        holder.category.setText(items[position].getCategory());
        holder.name.setText(items[position].getImgName());
        holder.price.setText(items[position].getPrice());
        Glide.with(mContext)
                .asBitmap().load(items[position].getImgUrl())
                .into(holder.image);
        holder.addtocart.setText("Add to Cart");
        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean s = addItems(view);
                if(s == true){
                    Toast.makeText(view.getContext(),"Added item: "+itemListData.getImgName()+" to cart",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(view.getContext(),"Error in adding item",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public boolean addItems(View v){
        boolean success = false;
        DBHelperShopCart dbHelperShopCart = new DBHelperShopCart(v.getContext());
        long row = dbHelperShopCart.addToCart(cart);
        if(row>0){
            success = true;
        }
        return success;
    }

    @Override
    public int getItemCount() {
        return items.length;
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