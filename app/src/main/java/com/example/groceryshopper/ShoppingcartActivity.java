package com.example.groceryshopper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groceryshopper.Database.DBHelperOrder;
import com.example.groceryshopper.Database.DBHelperShopCart;
import com.example.groceryshopper.Model.CartModel;

import java.util.List;

public class ShoppingcartActivity extends AppCompatActivity {
    TextView user;
    static TextView txttotalAmount;
    String uname;
    public static String userN;
    private CartModel[] cartModels;
    static double[] prices;
    double total = 0.0;
    //Button btnUpdate;
    static RecyclerViewAdapter2 adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);
        Intent intent = getIntent();
        uname = intent.getStringExtra(CategorylistActivity.USERNAME);
        userN = uname;
        user = findViewById(R.id.user);
        txttotalAmount = findViewById(R.id.totalAmount);
        //btnUpdate = findViewById(R.id.updateBtn);
        //btnUpdate.setOnClickListener(btnClicked);

        user.setText(uname);
        initListElements1();
    }

    private void initListElements1() {
        DBHelperShopCart dbHelperShopCart = new DBHelperShopCart(this);
        List<CartModel> listCartItems = dbHelperShopCart.getCartItems(uname);
        if(!listCartItems.isEmpty()) {
            cartModels = new CartModel[listCartItems.size()];
            prices = new double[listCartItems.size()];
            cartModels = listCartItems.toArray(cartModels);

            for(int i = 0 ; i < prices.length; i++){
                String str = cartModels[i].getPrice().substring(4);
                prices[i] = Double.parseDouble(str);
                total += prices[i];
            }
            String totalAmount= "Rs. "+String.format("%.2f", total);
            txttotalAmount.setText(totalAmount);
            initRecyclerView1();
        }else{
            Intent intent1 = new Intent(this,EmptyCartActivity.class);
            intent1.putExtra("user", uname);
            startActivity(intent1);
        }
    }

    private void initRecyclerView1() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter2 = new RecyclerViewAdapter2(cartModels,this);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

        public static void onClickUpdate(View v) {
            double total = 0.0;
            prices = adapter2.getPriceArray();
            for(int i = 0 ; i < prices.length; i++){
                total+=prices[i];
            }
            String totalAmount= "Rs. "+String.format("%.2f", total);
            txttotalAmount.setText(totalAmount);
        }

    public void placeOrder(View view){
        DBHelperOrder dbHelperOrder = new DBHelperOrder(this);
        dbHelperOrder.addToOrders(cartModels);
        Toast.makeText(this, "Order added", Toast.LENGTH_LONG).show();
    }

    public void logout(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ShoppingcartActivity.this, DashboardActivity.class);
            intent.putExtra("USERNAME", uname);
            finish();
            startActivity(intent);
        }

        return true;
    }
}