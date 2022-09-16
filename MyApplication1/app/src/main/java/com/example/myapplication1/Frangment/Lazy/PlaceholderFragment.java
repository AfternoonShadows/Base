package com.example.myapplication1.Frangment.Lazy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication1.R;

/**
 *
 **/
public class PlaceholderFragment extends BaseLazyFragment {
    private final String TAG = getClass().getSimpleName();
    private volatile static PlaceholderFragment mPlaceholderFragment;
    private Button button;

    public static PlaceholderFragment getInstance() {
        if (mPlaceholderFragment == null) {
            synchronized (PlaceholderFragment.class) {
                if (mPlaceholderFragment == null) {
                    mPlaceholderFragment = new PlaceholderFragment();
                }
            }
        }
        return mPlaceholderFragment;
    }

    public void release() {
        mPlaceholderFragment = null;
    }

    @Override
    public void loadDataStart() {
        Log.e(TAG, "loadDataStart");
        button.setText("dsfsdfsd");
        mLoadDataFinished = true;
    }

    @Override
    protected void findViewById(View view) {
        Log.e(TAG, "findViewById");
        button = view.findViewById(R.id.btn_fragment_one);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "btn_fragment_one");
            }
        });
    }

    @Override
    protected View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "initRootView");
        return inflater.inflate(R.layout.fragment_one_activity, container, false);
    }
}