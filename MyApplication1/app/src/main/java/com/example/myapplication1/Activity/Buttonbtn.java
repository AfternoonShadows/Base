package com.example.myapplication1.Activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.InformationAccess.AccessBundleIntent;
import com.example.myapplication1.R;

public class Buttonbtn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

    }
    public void btn(View view){
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.example.myapplication1","com.example.myapplication1.InformationAccess.AccessBundleIntent");
        intent.setComponent(componentName);
        startActivity(intent);
    }
}
