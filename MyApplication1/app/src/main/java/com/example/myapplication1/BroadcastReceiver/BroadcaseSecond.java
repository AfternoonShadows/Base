package com.example.myapplication1.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcaseSecond extends BroadcastReceiver {
    public BroadcaseSecond(){
        Log.e("BroadcaseSecond","实例化BroadcaseSecond");
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"456",Toast.LENGTH_SHORT).show();
        Log.e("BroadcaseSecond","onReceive");
    }
}
