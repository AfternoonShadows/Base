package com.example.myapplication1.Animation;

import android.animation.ObjectAnimator;

import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;

/**
 *
 **/
public class moveAnimation extends AppCompatActivity {
    private final String TAG = "moveAnimation";
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_moveview_activity);
        textView = findViewById(R.id.moveview_tv);
    }

    public void up(View v) {
        Log.e(TAG, "up");
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "translationY", -200f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    public void down(View v) {
        Log.e(TAG, "down");
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "translationY", 200f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();

    }

    public void right(View v) {
        Log.e(TAG, "right");
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "translationX", 200f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    public void left(View v) {
        Log.e(TAG, "left");
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "translationX", -200f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    public void curved(View v) {
        Log.e(TAG, "curved");
        // arcTo() and PathInterpolator only available on API 21+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Path path = new Path();
//            path.arcTo(0f, 0f, 1000f, 1000f, 270f, -180f, true);
//            PathInterpolator pathInterpolator = new PathInterpolator(path);
//            ObjectAnimator animation = ObjectAnimator.ofFloat(textView, "translationX", 100f);
//            animation.setInterpolator(pathInterpolator);
//            animation.start();
            Path path = new Path();
            path.arcTo(0, 0, 1000f, 1000f, 90f, 180f, true);
            ObjectAnimator animator = ObjectAnimator.ofFloat(textView, View.X, View.Y, path);
            animator.setDuration(2000);
            animator.start();
        }
    }
}
