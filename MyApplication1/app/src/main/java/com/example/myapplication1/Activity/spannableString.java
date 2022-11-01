package com.example.myapplication1.Activity;


import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

import javax.xml.parsers.SAXParser;

public class spannableString extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spannablestring);
        TextView tv = findViewById(R.id.spannablestring);
        SpannableString spannableString = new SpannableString("红色字体蓝色背景 点击事件");
        spannableString.setSpan(new ForegroundColorSpan(Color.RED),0,4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new BackgroundColorSpan(Color.BLUE),4,8, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ImageSpan(this,R.drawable.ic_launcher_background),8,9,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(spannableString);
    }
}
