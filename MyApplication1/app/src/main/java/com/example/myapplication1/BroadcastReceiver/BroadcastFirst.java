package com.example.myapplication1.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastFirst extends BroadcastReceiver {
    public BroadcastFirst(){
        Log.e("BroadcastFirst","实例化BroadcastFirst");
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"123",Toast.LENGTH_SHORT).show();
        Log.e("BroadcastFirst","onReceive");
    }
}
