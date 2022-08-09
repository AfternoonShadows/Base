package com.example.myapplication1.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.MVP.view.View;
import com.example.myapplication1.R;

import java.util.List;

public class BroadcastMain extends AppCompatActivity {
    private RegisterBR registerBR;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_main);
        Button button = findViewById(R.id.BroadcastButton);
        Button button1 = findViewById(R.id.BroadcastButton1);
        Button button2 = findViewById(R.id.BroadcastButton2);
        Button button3 = findViewById(R.id.BroadcastButton3);
        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Log.e("onClick","button");
                Intent intent = new Intent();
//                获取action
                intent.setAction("android.intent.action");
//                静态注册需要设置从那一个包名到到哪一个包的类名
                intent.setComponent(new ComponentName(getPackageName(),"com.example.myapplication1.BroadcastReceiver.BroadcastFirst"));
                sendBroadcast(intent);
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Log.e("onClick","button1");
//              实例化过滤器
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("action.dynamic.gister");
//                实例化广播
                registerBR = new RegisterBR();
//                注册广播
                registerReceiver(registerBR,intentFilter);
                sendBroadcast(new Intent("action.dynamic.gister"));
            }
        });
        button2.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Log.e("onClick","button2");
//                获取某个包里面，action相同的所有receiver
                List<ResolveInfo> list = BroadcastMain.this.getPackageManager().queryBroadcastReceivers(new Intent("android.intent.action"),0);
                for(int i = 0 ; i < list.size() ; i++){
                    Intent intent = new Intent("android.intent.action");
                    Log.e("package",list.get(i).activityInfo.applicationInfo.packageName);
                    Log.e("class",list.get(i).activityInfo.name);
                    intent.setComponent(new ComponentName(list.get(i).activityInfo.applicationInfo.packageName, list.get(i).activityInfo.name));
                    sendBroadcast(intent);
                }
            }
        });
        button3.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Log.e("onClick","button");
            }
        });
    }
    public class RegisterBR extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("RegisterBR","动态注册广播");
        }
    }
   @Override
    protected void onDestroy() {
        if(registerBR != null)
            unregisterReceiver(registerBR);
        super.onDestroy();
    }
}
