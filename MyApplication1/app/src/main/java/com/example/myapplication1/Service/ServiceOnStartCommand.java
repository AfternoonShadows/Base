package com.example.myapplication1.Service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ServiceOnStartCommand extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("ServiceOnStartCommand","onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("ServiceOnStartCommand","onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("ServiceOnStartCommand","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("ServiceOnStartCommand","onDestroy");
    }
}
