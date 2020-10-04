package com.example.groceryshopper.Database;

import android.provider.BaseColumns;

public class ShopCartMaster {
    private ShopCartMaster(){
    }
    public static class ShopCartItems implements BaseColumns {
        public static final String TBL_NAME_3 = "shopCart";
        public static final String COL_NAME_ITEM_NAME="itemName";
        public static final String COL_NAME_ITEM_PRICE="itemPrice";
        public static final String COL_NAME_ITEM_QUANTITY="quantity";
        public static final String COL_NAME_USER_NAME="username";
    }
}
