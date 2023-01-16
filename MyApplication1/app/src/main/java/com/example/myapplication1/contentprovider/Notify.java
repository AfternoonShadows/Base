package com.example.myapplication1.contentprovider;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

/**
 * 通知.
 **/
public class Notify extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建管理器
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // 避免API不稳定(空的Notification)
        Notification notification = new NotificationCompat.Builder(getApplicationContext()).build();
        // 设置通知点击后的跳转到相应的活动
        PendingIntent pendingIntent =
                PendingIntent.getActivity(getApplication(), 0, new Intent(), 0);
        Notification notification1 =
                new NotificationCompat.Builder(getApplicationContext())
                        .setContentTitle("")
                        .setContentText("")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(1)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), 1))
                        .setSound(null)
                        .setVibrate(null)
                        .setLights(Color.GREEN,1000,1000)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(""))
                        .setPriority(1)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .build();
        // 通知显示
        notificationManager.notify(1, notification1);
        // 取消通知，和显示通知的id一致。
        notificationManager.cancel(1);
    }
}
