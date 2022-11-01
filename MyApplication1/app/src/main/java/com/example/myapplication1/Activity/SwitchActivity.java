package com.example.myapplication1.Activity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class SwitchActivity extends AppCompatActivity {
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_switch);
        aSwitch = findViewById(R.id.switch_on_off);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String status = aSwitch.isChecked()?"ON":"OFF";
                Toast.makeText(SwitchActivity.this,"status="+status,Toast.LENGTH_SHORT).show();
            }
        });
    }
}