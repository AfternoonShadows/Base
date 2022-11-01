package com.example.myapplication1.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myapplication1.R;

public class ActivityFirst extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityfirst);
        View button = findViewById(R.id.intenttest);
        View button1 = findViewById(R.id.intenttest1);
        button.setOnClickListener(new OnClick());
        button1.setOnClickListener(new OnClick());
    }
    public class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.intenttest:
//                    requestPhonePermission();
                    if(ContextCompat.checkSelfPermission(ActivityFirst.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(ActivityFirst.this,new String[]{Manifest.permission.CALL_PHONE},999);
                        Log.e("call phone permessions"," is request");
                    }else {
                        calllphone();
                    }
                    break;
                case R.id.intenttest1:
                    requestPhonePermission();
                    Intent intent1 = new Intent();
                    intent1.setAction(Intent.ACTION_CALL);
                    intent1.setData(Uri.parse("tel:"+12345));
                    startActivity(intent1);
                    break;
            }
        }
    }
    public void requestPhonePermission()
    {
        if(ContextCompat.checkSelfPermission(ActivityFirst.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},10010);
            Log.e("call phone permessions"," is request");
        }else {
            Log.e("call phone permessions","request success");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==10010){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                calllphone();
            }
            else
                Toast.makeText(ActivityFirst.this,"permission is refuse",Toast.LENGTH_SHORT).show();
        }
    }
    public void calllphone(){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:"+1234));
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
