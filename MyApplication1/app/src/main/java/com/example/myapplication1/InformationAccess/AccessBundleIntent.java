package com.example.myapplication1.InformationAccess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class AccessBundleIntent extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informationaccess);
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        Log.e("bundle",bundle.getString("put"));
    }
}
