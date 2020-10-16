package com.example.groceryshopper.Database;

import android.provider.BaseColumns;

public class FeedbackMaster {

    private FeedbackMaster(){
    }
    public static class Feedback implements BaseColumns{
        public static final String TBL_NAME = "feedback";
        public static final String COL_NAME_NAME = "feedName";
        public static final String COL_NAME_EMAIL = "feedEmail";
        public static final String COL_NAME_MESSAGE = "feedMessage";
    }
}
