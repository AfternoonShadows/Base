package com.example.myapplication1.Animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

/**
 *
 **/
public class ATweenAnimation extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_tweenanimation_activity);
        textView = findViewById(R.id.aTweenAnimation_tv);
    }
    public void start(View view){
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.atweenanimation_tv);
        textView.startAnimation(hyperspaceJumpAnimation);
    }
}
