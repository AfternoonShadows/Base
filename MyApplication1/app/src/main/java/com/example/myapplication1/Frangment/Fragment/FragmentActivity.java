package com.example.myapplication1.Frangment.Fragment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication1.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 **/
public class FragmentActivity extends AppCompatActivity implements fragmentListener{
    private final String TAG = "FragmentActivity";
    private ViewPager mViewPager;
    private List<Fragment> list = new ArrayList<>();
    private FragmentOneActivity fragmentOneActivity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");
        setContentView(R.layout.fragment_activity);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }

    public void init() {
        mViewPager = findViewById(R.id.vp_fragment_activity);
        list.add(new FragmentOneActivity());
        list.add(new FragmentTwoActivity());
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    public void info(String s) {
        Log.e(TAG,"setFragmentListener"+s);
    }
}
