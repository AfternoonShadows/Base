package com.example.myapplication1.CallBack;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class My extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callback_my);
        TextView textView = findViewById(R.id.callbacktextview);
        findViewById(R.id.callbackbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                You you = new You();
                Log.e("MY:","call phone");
                them them = new them();
                you.setcall("my", "qwww", new ContentCallBack() {
                    @Override
                    public void ContentCallBackResualt(String resualt) {
                        textView.setText(resualt);
                        Log.e("MY:",resualt);
                    }
                });
                Log.e("MY:","end");
            }
        });
    }
}
