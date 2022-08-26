package com.example.myapplication1.MyStyle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class MySeekBarStyle extends AppCompatActivity {
    private final String TAG = "MySeekBarStyle";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.myseekbar);
        SeekBar seekBar = findViewById(R.id.msb_mystyle);
        SeekBar seekBarone = findViewById(R.id.msb_one_mystyle);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e(TAG,"onProgressChanged");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e(TAG,"onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e(TAG,"onStopTrackingTouch");
            }
        });
        seekBarone.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e(TAG,"onProgressChanged");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e(TAG,"onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e(TAG,"onStopTrackingTouch");
            }
        });
    }
}
