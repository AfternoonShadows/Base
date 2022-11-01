package com.example.myapplication1.Activity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Switch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class activityClockButton extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int[] i = {0};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        Chronometer chronometer = findViewById(R.id.chronometer);
        View button = findViewById(R.id.activityClockButton);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                switch(i[0]){
                    case 0:
                        // 每次开始计时前，先复位下当前时间起点，否则时间不正确
                        chronometer.setBase(SystemClock.elapsedRealtime());
                        // 开始计时
                        chronometer.start();
                        i[0]++;
                        break;
                    case 1:
                        // 停止计时
                        chronometer.stop();
                        i[0]++;
                        break;
                    case 2:
                        // 重置计时器到起点（复归）
                        chronometer.setBase(SystemClock.elapsedRealtime());
                        i[0]++;
                        break;
                    case 3:
                        // 设置是否倒计时模式
                        chronometer.setCountDown(true);
                        // 复归重置计时起点毫秒数，这里设置10分钟倒计时
                        chronometer.setBase(SystemClock.elapsedRealtime() + 1000 * 60 * 10);
                        // 开始倒计时计时
                        chronometer.start();
                        i[0]++;
                        break;
                    default:
                        i[0] = 0;
                        break;
                }
            }
        });
    }
}
