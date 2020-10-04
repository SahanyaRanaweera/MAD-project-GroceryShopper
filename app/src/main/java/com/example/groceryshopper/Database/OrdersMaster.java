package com.example.groceryshopper.Database;

import android.provider.BaseColumns;

public class OrdersMaster {
    private OrdersMaster(){
    }
    public static class Orders implements BaseColumns {
        public static final String TBL_NAME_4 = "orders";
        public static final String COL_NAME_ITEM_NAME="itemName";
        public static final String COL_NAME_ITEM_PRICE="itemPrice";
        public static final String COL_NAME_ITEM_QUANTITY="quantity";
        public static final String COL_NAME_USER_NAME="username";
        public static final String COL_NAME_STATUS="status";
    }
}
