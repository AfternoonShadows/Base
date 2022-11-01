package com.example.myapplication1.Activity;




import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

public class activityImageview extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        ImageView imageView = findViewById(R.id.activity_imageview);
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        //        create a matrix
        Matrix matrix = new Matrix();
        matrix.preRotate(45,50,50);
        imageView.setImageMatrix(matrix);

        Switch s = findViewById(R.id.activity_switch);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(activityImageview.this, "on", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(activityImageview.this, "off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        RadioGroup radioGroup = findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                Toast.makeText(activityImageview.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
