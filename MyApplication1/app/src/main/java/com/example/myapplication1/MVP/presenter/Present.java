package com.example.myapplication1.MVP.presenter;

import android.util.Log;

import com.example.myapplication1.MVP.model.Model;
import com.example.myapplication1.MVP.view.IView;

public class Present implements IPresenter, Model.LoadDataCall{
    private IView iView;
    private Model model;
    public Present(IView iView){
        this.iView = iView;
        model = new Model();
    }
    @Override
    public void loadData() {
        Log.e("Present","loadData");
        model.getData(Present.this);
    }

    @Override
    public void success(String text) {
        Log.e("Present","success");
        iView.showData("hello world");
    }
}
