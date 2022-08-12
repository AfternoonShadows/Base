package com.example.myapplication1.InformationAccess;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class AccessMain extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informationaccess);
    }
    public void AccessBundle(View view){
        Log.e("AccessMain","AccessBundle");
        Intent intent =new Intent(this,AccessBundleIntent.class);
        Bundle bundle = new Bundle();
        bundle.putString("put","set");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void AccessStatic(View view){
        Log.e("AccessMain","AccessStatic");
    }
    public void AccessApplication(View view){
        Log.e("AccessMain","AccessApplication");
    }
    public void AccessAndroidS(View view){
        Log.e("AccessMain","AccessAndroidS");
    }
    public void AccessStorage(View view){
        Log.e("AccessMain","AccessStorage");
    }
    public void AccessAndroid(View view){
        Log.e("AccessMain","AccessAndroid");
    }
    public void AccessEventBus(View view){
        Log.e("AccessMain","AccessEventBus");
    }
    public void AccessHandler(View view){
        Log.e("AccessMain","AccessHandler");
        Intent intent = new Intent(this,AccessHandle.class);
        startActivity(intent);
    }
    public  Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 100)
                Log.e("Handler","handleMessage");
            super.handleMessage(msg);
        }
    };
}
