package com.example.myapplication1.Animation;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.SpringAnimation;

import com.example.myapplication1.R;

/**
 *
 **/
public class SpringAnimationActivity extends AppCompatActivity {
    public final static String TAG = SpringAnimationActivity.class.getSimpleName();
    private SeekBar mStiffness;
    private SeekBar mDamping;
    private View mBox;
    private RelativeLayout mRoot;
    private TextView mTvStiffness;
    private TextView mTvDamping;
    private SeekBar mFinalPosition;
    private TextView mFvSpring;
    private Button mBtnReset;

    private VelocityTracker velocityTracker;
    private float downX, downY;
    private SpringAnimation animationX, animationY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_spring_translation);
//        ButterKnife.bind(this);
        mStiffness = findViewById(R.id.stiffness);
        mDamping = findViewById(R.id.damping);
        mBox = findViewById(R.id.box);
        mRoot = findViewById(R.id.root);
        mTvStiffness = findViewById(R.id.tv_stiffness);
        mTvDamping = findViewById(R.id.tv_damping);
        mFinalPosition = findViewById(R.id.final_position);
        mFvSpring = findViewById(R.id.tv_spring);
        mBtnReset = findViewById(R.id.tv_reset);
        findViewById(android.R.id.content).setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

        velocityTracker = VelocityTracker.obtain();
        mRoot.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "getX : " + motionEvent.getX() + " getY : " + motionEvent.getY() +
                                " getRawX : " + motionEvent.getRawX() + " getRawY : " + motionEvent.getRawY());
                        downX = motionEvent.getX();
                        downY = motionEvent.getY();
                        velocityTracker.addMovement(motionEvent);
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        if (animationX != null) {
                            animationX.cancel();
                            animationY.cancel();
                        }
                        mBox.setTranslationX(motionEvent.getX() - downX);
                        mBox.setTranslationY(motionEvent.getY() - downY);
                        velocityTracker.addMovement(motionEvent);
                        return true;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        velocityTracker.computeCurrentVelocity(1000);
                        if (mBox.getTranslationX() != 0) {
                            animationX = new SpringAnimation(mBox, SpringAnimation.TRANSLATION_X, 0);
                            animationX.getSpring().setStiffness(getmStiffness());
                            animationX.getSpring().setDampingRatio(getmDamping());
                            animationX.getSpring().setFinalPosition(getFinalPositionX());
                            animationX.setStartVelocity(velocityTracker.getXVelocity());
                            animationX.start();
                        }
                        if (mBox.getTranslationY() != 0) {
                            animationY = new SpringAnimation(mBox, SpringAnimation.TRANSLATION_Y, 0);
                            animationY.getSpring().setStiffness(getmStiffness());
                            animationY.getSpring().setDampingRatio(getmDamping());
                            animationY.getSpring().setFinalPosition(getFinalPositionY());
                            animationY.setStartVelocity(velocityTracker.getYVelocity());
                            animationY.start();
                        }
                        velocityTracker.clear();
                        Log.d(TAG, " FinalPositionX = " + mFinalPosition.getProgress());

                        return true;
                }
                return false;
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animationX != null) {
                    animationX.cancel();
                    animationY.cancel();
                }
                mDamping.setProgress(0);
                mStiffness.setProgress(0);
                mFinalPosition.setProgress(0);
            }
        });
    }

    private float getmStiffness() {
        return Math.max(mStiffness.getProgress(), 1f);
    }

    private float getmDamping() {
        return mDamping.getProgress() / 100f;
    }

    private float getFinalPositionX() {
        return mFinalPosition.getProgress() / 100f * getWindowManager().getDefaultDisplay().getWidth();
    }

    private float getFinalPositionY() {
        return mFinalPosition.getProgress() / 100f * getWindowManager().getDefaultDisplay().getHeight();
    }
}
