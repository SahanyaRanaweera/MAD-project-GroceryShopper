package com.example.groceryshopper.Database;

import android.provider.BaseColumns;

public class UsersMaster {
    private UsersMaster() {
    }
    public static class Customers implements BaseColumns{
        public static final String TBL_NAME = "customers";
        public static final String COL_NAME_FULL_NAME = "fullname";
        public static final String COL_NAME_ADDRESS = "address";
        public static final String COL_NAME_HOME_NO = "home";
        public static final String COL_NAME_MOBILE = "mobile";
        public static final String COL_NAME_EMAIL = "email";
        public static final String COL_NAME_USERNAME = "username";
        public static final String COL_NAME_PASSWORD = "password";
    }

}
