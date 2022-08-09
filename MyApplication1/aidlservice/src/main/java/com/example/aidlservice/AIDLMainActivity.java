package com.example.aidlservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AIDLMainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    /*
    private AIDLService.onBind onBind;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e(getPackageName()+"Connected",componentName.toString());
            onBind = (AIDLService.onBind) iBinder;
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e(getPackageName()+"Disconnected",componentName.toString());
        }
    };

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.AIDLServicetext);
        button = findViewById(R.id.AIDLServiceButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("AIDLMainActivity","onClick");
                bindService(AIDLMainActivity.this);
            }
        });
    }
    public void bindService(Context context){
//        bindService(new Intent(context,AIDLService.class),connection,BIND_AUTO_CREATE);
        Log.e("AIDLMainActivity","bindService");
    }
}