package com.example.myapplication1.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class TextShowHide extends AppCompatActivity {
    private View button;
    private boolean flag = true;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_show_hide);
        button = findViewById(R.id.showHideButton);
        textView = findViewById(R.id.showHideText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    textView.setVisibility(View.GONE);
                    flag = false;
                }else
                {
                    textView.setVisibility(View.VISIBLE);
                    flag = true;
                }
            }
        });
    }
}
