package com.example.myapplication1.BarStyle;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class ProgressbarActivity extends AppCompatActivity {
    final int[] status = {0};
    ProgressBar progressBar;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        progressBar = findViewById(R.id.progressbar_horizontal);
        seekBar = findViewById(R.id.seekbar);
//        acquire progressBar
        thread.start();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("onStartTrackingTouch", "stop");
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                status[0] = progress;
                seekBar.setProgress(progress);
                Log.d("onProgressChanged", String.valueOf(progress));
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("onStopTrackingTouch","start");
            }
        });
    }
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(status[0] <100)
            {
                try {
                    status[0]++;
                    Thread.sleep(100);
                    progressBar.setProgress(status[0]);
                    seekBar.setProgress(status[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
}
