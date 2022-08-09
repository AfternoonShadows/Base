package com.example.aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aidlservice.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private IMyAidlInterface iMyAidlInterface;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e(getPackageName()+"Connected",componentName.toString());
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
            try {
                iBinder.linkToDeath(new IBinder.DeathRecipient() {
                    @Override
                    public void binderDied() {
                        Log.e("linkToDeath","failing");
                        bindService();
                    }
                },1000);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e(getPackageName()+"Disconnected",componentName.toString());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(getPackageName(),"onCreate");
        textView = findViewById(R.id.AIDLServicetext);
        button = findViewById(R.id.AIDLServiceButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("onClick","onClick");
                bindService();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            iMyAidlInterface.basicTypes(0,0,true,0,0,"0");
                            Log.e("onClick","basicTypes");
                        } catch (InterruptedException | RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
    public void bindService(){
        Intent intent = new Intent();
        intent.setAction("com.example.aidlservice");
        ComponentName c = new ComponentName("com.example.aidlservice","com.example.aidlservice.AIDLService");
        intent.setComponent(c);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }
}