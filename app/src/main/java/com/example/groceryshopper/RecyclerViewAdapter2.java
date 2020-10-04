package com.example.groceryshopper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.groceryshopper.Database.DBHelperShopCart;
import com.example.groceryshopper.Model.CartModel;



public class RecyclerViewAdapter2 extends
        RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {
    private static final String TAG = "test.recyclerview.RecyclerViewAdapter2";
    private CartModel[] c1;
    private Context mContext;
    double[] priceArray;

    public RecyclerViewAdapter2(CartModel[] c1 , Context mContext) {
        this.c1 = c1;
        this.mContext = mContext;
        priceArray = new double[c1.length];
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cart,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        final CartModel cartData = c1[position];

        holder.productName.setText(c1[position].getItemName());
        holder.qty.setText(Integer.toString(c1[position].getQuantity()));
        final String priceValue = c1[position].getPrice().substring(4);
        double priceValue1 = Double.parseDouble(priceValue) * c1[position].getQuantity();
        priceArray[position] = priceValue1;
        String totPrice = "Rs. "+String.format("%.2f", priceValue1);
        holder.price.setText(totPrice);
        holder.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double nValue = update(view,holder,priceValue);
                priceArray[position] = nValue;
                Toast.makeText(view.getContext(),"Updating quantity...",Toast.LENGTH_LONG).show();
                ShoppingcartActivity.onClickUpdate(view);
            }
        });

    }

    public double[] getPriceArray() {
        return priceArray;
    }

    public double update(View v, @NonNull ViewHolder h, String priceOld){
        double valNew = Double.parseDouble(priceOld) * Integer.parseInt(h.qty.getText().toString());
        String valString = "Rs. "+String.format("%.2f", valNew);
        h.price.setText(valString);
        DBHelperShopCart dbHelperShopCart = new DBHelperShopCart(v.getContext());
        dbHelperShopCart.updateQuantity(Integer.parseInt(h.qty.getText().toString()),h.productName.getText().toString(),CategoryActivity.userN);

        return valNew;
    }


    @Override
    public int getItemCount() {
        return c1.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView productName;
        EditText qty;
        TextView price;
        Button updateBtn;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            qty = itemView.findViewById(R.id.edtQty);
            price = itemView.findViewById(R.id.priceVal);
            updateBtn = itemView.findViewById(R.id.updateBtn);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
