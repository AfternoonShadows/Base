package com.example.myapplication1.MVP.presenter;

import android.content.Context;
import android.util.Log;

import com.example.myapplication1.MVP.model.Model;
import com.example.myapplication1.MVP.view.IView;
import com.example.myapplication1.MVP.view.MvpView;

public class Present {
    private Model model;
    private MvpView.IVew iVew;

    public Present() {
        Log.e("IView", IView.class.getSimpleName());
        model = new Model();
        model.setLoadDataCall(new Model.LoadDataListener() {
            @Override
            public void success(String text) {
                iVew.getdata(text);
            }
        });
    }

    public void setiVew(MvpView.IVew iVew) {
        this.iVew = iVew;
    }

    public String notifytext() {
        return model.getData();
    }

    public void notifyone() {
        model.notifyone();
    }
}
