package com.example.myapplication1.Animation;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import com.example.myapplication1.R;

/**
 *
 **/
public class springAnimation extends AppCompatActivity {
    private final String TAG = "springAnimation";
    private SpringAnimation springAnimation;
    private View button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_springanimation);
        button = findViewById(R.id.view_springAnimation);
    }

    public void springAnimation(View view) {
        Log.e(TAG, "springAnimation");
//        创建动画   以视图的Y轴为终点，以零为起点
        springAnimation = new SpringAnimation(button, DynamicAnimation.SCALE_X, 0f);
//        设置阻尼 set damping
        springAnimation.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
//        设置刚度 set stiffness
        springAnimation.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
//        start animation
        springAnimation.start();
//        判断是否有阻尼，如果有阻尼则返回真，否则返回false(不能回到静止状态)
        /*
        if(springAnimation.canSkipToEnd()){
//            停止动画
            springAnimation.cancel();
        }else{
//            停止动画
            springAnimation.skipToEnd();
        }

         */
    }

    public void canclespringAnimation(View view) {
        Log.e(TAG, "canclespringAnimation");
        springAnimation = new SpringAnimation(button, DynamicAnimation.SCALE_X, 1f);
//        设置阻尼 set damping
        springAnimation.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
//        设置刚度 set stiffness
        springAnimation.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
//        start animation
        springAnimation.start();
    }

}
