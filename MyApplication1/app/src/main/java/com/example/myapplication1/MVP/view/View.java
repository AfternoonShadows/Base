package com.example.myapplication1.MVP.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.MVP.presenter.IPresenter;
import com.example.myapplication1.MVP.presenter.Present;
import com.example.myapplication1.R;

public class View extends AppCompatActivity implements IView {
    private IPresenter iPresenter;
    private TextView textView;
    private android.view.View button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvpfirst);
        Log.e("View","onCreate");
        iPresenter = new Present(View.this);
        textView = findViewById(R.id.mvptext);
        button = findViewById(R.id.mvpbutton);
        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Log.e("View","button");
                iPresenter.loadData();
            }
        });
    }

    @Override
    public void showLoadingProgress(String message) {
        Log.e("View","showLoadingProgress");
    }

    @Override
    public void showData(String text) {
        Log.e("View","showData");
        textView.setText(text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
