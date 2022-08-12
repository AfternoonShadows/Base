package com.example.myapplication1.MVP.model;

import android.util.Log;

public class Model {
    private LoadDataListener loadDataListener;

    public void setLoadDataCall(LoadDataListener loadDataListener) {
        Log.e("Model-setLoadDataCall", "setLoadDataCall");
        this.loadDataListener = loadDataListener;
    }

    public void notifyone() {
        Log.e("Model", "notify");

        if (loadDataListener != null) {
            loadDataListener.success("12312");
        }


    }


    public String getData() {
        return "Hello";
    }

    public interface LoadDataListener {
        public void success(String text);
    }
}
