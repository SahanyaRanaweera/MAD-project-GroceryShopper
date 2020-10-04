package com.example.groceryshopper.Database;

import android.provider.BaseColumns;

public class ItemsMaster {
    private ItemsMaster(){
    }
    public static class Items implements BaseColumns{
        public static final String TBL_NAME_2 = "items";
        public static final String COL_NAME_I_CATEGORY = "iCategory";
        public static final String COL_NAME_I_IMG_URL = "iImgUrl";
        public static final String COL_NAME_I_IMG_NAME = "iImgName";
        public static final String COL_NAME_I_PRICE = "iPrice";

    }
}
