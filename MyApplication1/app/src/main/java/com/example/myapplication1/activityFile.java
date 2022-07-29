package com.example.myapplication1;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import java.io.File;

public class activityFile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityfile);
        File sdCard = Environment.getExternalStorageDirectory();
        Log.e("sdCard=", String.valueOf(sdCard));
        File sdCardDir = new File(sdCard,"PICTURE");
        Log.e("sdCardDir=", String.valueOf(sdCardDir));
        File sdCardDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        Log.e("sdCardDirectory", String.valueOf(sdCardDirectory));
        File sd = Environment.getStorageDirectory();
        Log.e("sd", String.valueOf(sd));
        File file = getFilesDir();
        Log.e("file", String.valueOf(file));
        File exfile = getExternalFilesDir(null);
        Log.e("exfile", String.valueOf(exfile));
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.e("SDcard","true");
        }else{
            Log.e("SDcard","false");
        }
    }
}
