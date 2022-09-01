package com.example.myapplication1.SeekBarScrollView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;
import com.example.myapplication1.BarStyle.VerticalSeekBarStyle;

public class SeekAndScrollActivity extends AppCompatActivity {
    private final String TAG= "MainActivity";
    private Switch aSwitch;
    private ScrollBindHelper scrollBindHelper;
    private ObservableScrollView observableScrollView;
    private VerticalSeekBarStyle verticalSeekBar;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar_scrollview);
        observableScrollView = findViewById(R.id.sv_ac_m);
        verticalSeekBar = findViewById(R.id.sb_ac_m);
        textView = findViewById(R.id.tv_ac_m);

        for (int i = 0; i < 1000; i++) {
            String s = (String) textView.getText();
            textView.setText(s+"wenzii"+i+"\r\n");
        }
        scrollBindHelper.bind(verticalSeekBar, observableScrollView);
    }
}