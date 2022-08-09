package com.example.myapplication1.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ServiceOnBind extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("ServiceOnBind","onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("ServiceOnBind","onBind");
        return new Bind();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("ServiceOnBind","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

   @Override
    public void onRebind(Intent intent) {
        Log.e("ServiceOnBind","onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("ServiceOnBind","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("ServiceOnBind","onDestroy");
    }
    class Bind extends Binder{
        public void write(){
            Log.e("Bind","Bind");
        }
    }
}
