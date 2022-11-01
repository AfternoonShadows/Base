package com.example.myapplication1.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

import java.util.Timer;
import java.util.TimerTask;

public class activityHandlerAccept extends AppCompatActivity {
    private int i = 5;
    private TextView tv;
    Timer timer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        tv = findViewById(R.id.handlertext);
        tv.setText(String.valueOf(i));
        timer.schedule(timerTask,1000,1000);
        View button = (Button)findViewById(R.id.buttonw);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = mHandler.obtainMessage();
                message.what = 111;
                mHandler.sendMessage(message);
                Log.e("button","button");
//                Message message = Message.obtain(mHandler);
//                message.what = 111;
//                message.sendToTarget();
            }
        });
    }
//    create anonymous inner class create Handler class
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==111) {
                tv.setText("String.valueOf(i)");
//              startActivity(new Intent(activityHandler.this, Button.class));
            }
        }
    };
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            i--;
            tv.setText(String.valueOf(i));
            if(i==0)
            {
                timer.cancel();
            }
        }
    };

}
