package com.example.myapplication1.MVP.model;

import android.util.Log;

public class Model implements IModel {
    @Override
    public void getData(LoadDataCall loadDataCall) {
        Log.e("Model-implements","Persion");
        loadDataCall.success("success");
    }

    public interface LoadDataCall{
        public void success(String text);
    }
}
