package com.example.myapplication1.Service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class ServiceMain extends AppCompatActivity {
    private ServiceOnBind.Bind bind = null;
    private Intent intent = null;
//    连接服务
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("onServiceConnected",name.toString());
            bind = (ServiceOnBind.Bind) service;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("onServiceDisconnected","onServiceDisconnected");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_main);
        Log.e("ServiceMain","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ServiceMain","onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bind != null)
            unbindService(connection);
    }
    public void Bind(View view){
        Log.e("ServiceMain","Bind");
        bindService(new Intent(this,ServiceOnBind.class),connection, BIND_AUTO_CREATE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bind.write();
            }
        }).start();

    }
    public void OnStartCommand(View view){
        Log.e("ServiceMain","OnStartCommand");
        intent = new Intent(this,ServiceOnBind.class);
        startService(intent);
    }
    public void OnStop(View view){
        Log.e("ServiceMain","OnStop");
        if(intent != null) {
            stopService(intent);
            intent = null;
        }
    }
    public void OnBind(View view){
        Log.e("ServiceMain","OnBind");
        if(bind != null) {
            unbindService(connection);
            bind = null;
        }
    }
}
