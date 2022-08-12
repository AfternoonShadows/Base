package com.example.myapplication1.InformationAccess;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class AccessHandle extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informationaccess);
        AccessMain accessMain = new AccessMain();
        Message message = new Message();
        message.what = 100;
        accessMain.handler.sendMessage(message);
    }
}
