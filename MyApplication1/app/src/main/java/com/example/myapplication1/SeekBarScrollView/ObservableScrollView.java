package com.example.myapplication1.SeekBarScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;

/**
 *
 **/
public class ObservableScrollView extends ScrollView {
    private final String TAG = "ObservableScrollView";

    private ScrollViewListener scrollViewListener;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //设置接口
    public interface ScrollViewListener {
        void onScrollChange(ObservableScrollView scrollView, int x, int y, int oldx, int oldy);
    }

    //设置调用接口的方法
    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    //回调进行数据传递
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Log.e(TAG, "onScrollChanged :" + " l = " + l + " t = " + t + " oldl = " + oldl + " oldt = " + oldt);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChange(this, l, t, oldl, oldt);
        }
    }

    //修改scrollview位置
    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);

    }
}
