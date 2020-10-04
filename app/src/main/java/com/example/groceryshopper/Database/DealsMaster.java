package com.example.groceryshopper.Database;

import android.provider.BaseColumns;

public class DealsMaster {
    private DealsMaster(){
    }
    public static class Deals implements BaseColumns {
        public static final String TBL_NAME_1 = "dealsTable";
        public static final String COL_NAME_CATEGORY = "category";
        public static final String COL_NAME_IMG_URL = "img";
        public static final String COL_NAME_IMG_NAME = "imgName";
        public static final String COL_NAME_PRICE = "price";
    }
}
