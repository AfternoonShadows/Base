package com.example.myapplication1.Animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.example.myapplication1.R;

/**
 *
 **/
public class mFrameAnimation extends AppCompatActivity {
    private final static String TAG = mFrameAnimation.class.getSimpleName();
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_fanimation);
        ImageView imageView = findViewById(R.id.img_frame_animation);
        imageView.setBackgroundResource(R.drawable.m_frame_animation);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();

    }
    public void stop(View v){
        animationDrawable.stop();
        for (int i = 0; i < animationDrawable.getNumberOfFrames(); i++) {
            if (animationDrawable.getCurrent() == animationDrawable.getFrame(i)) {
                Log.e(TAG, "输出当前帧的位置 i: " + i);
            }
        }
    }
}
