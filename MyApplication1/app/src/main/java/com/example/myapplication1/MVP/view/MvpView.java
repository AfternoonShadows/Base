package com.example.myapplication1.MVP.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.MVP.presenter.IPresenter;
import com.example.myapplication1.MVP.presenter.Present;
import com.example.myapplication1.MVP.presenter.Presentone;
import com.example.myapplication1.R;

public class MvpView extends AppCompatActivity{
    private static final String TAG = "MvpView";
    private Present presenter;
    private TextView textView;
    private android.view.View button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvpfirst);
        Log.e("View", "onCreate");
        presenter = new Present();
        textView = findViewById(R.id.mvptext);
        button = findViewById(R.id.mvpbutton);
        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Log.e(TAG, "button onClick:");
//                textView.setText(presenter.notifytext());
                presenter.setiVew(iView);
                presenter.notifyone();
            }
        });
    }
    IVew iView = new IVew() {
        @Override
        public void getdata(String test) {
            textView.setText(test);
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public interface IVew{
        public void getdata(String test);
    }
}
