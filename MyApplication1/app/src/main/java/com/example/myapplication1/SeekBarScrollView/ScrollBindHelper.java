package com.example.myapplication1.SeekBarScrollView;

import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import com.example.myapplication1.BarStyle.VerticalSeekBarStyle;

/**
 *
 **/
public class ScrollBindHelper implements SeekBar.OnSeekBarChangeListener, ObservableScrollView.ScrollViewListener {
    private final String TAG = "ScrollBindHelper";

    private final VerticalSeekBarStyle seekBar;
    private final ObservableScrollView scrollView;
    private final View scrollContent;
    private static ScrollBindHelper helper;

    /**
     * 使用静态方法来绑定逻辑，代码可读性更高。
     */
    public static ScrollBindHelper bind(VerticalSeekBarStyle seekBar, ObservableScrollView scrollView) {
        //初始化工具类
        //封装好的获取屏幕工具类  进行初始化
        helper = new ScrollBindHelper(seekBar, scrollView);
        seekBar.setOnSeekBarChangeListener(helper);
        scrollView.setScrollViewListener(helper);
        return helper;
    }

    //设置全局属性
    private ScrollBindHelper(VerticalSeekBarStyle seekBar, ObservableScrollView scrollView) {
        this.seekBar = seekBar;
        this.scrollView = scrollView;
        //获取scrollview的第一个孩子的高度，在这里第一个孩子就是就是TextView
        this.scrollContent = scrollView.getChildAt(0);
    }

    //用户是否正在拖动SeekBar的标志
    private boolean isUserSeeking = false;

    //获取TextView的高度
    private int getContentRange() {
        Log.e(TAG, "getContentRange:" + scrollContent.getHeight());
        return scrollContent.getHeight();
    }

    //获取滚动范围
    private int getScrollRange() {
        Log.e(TAG, "getScrollRange:" + (scrollContent.getHeight() - scrollView.getHeight()));
        //换句话说就是TextView的高度 -  Scrollview的高度
        return scrollContent.getHeight() - scrollView.getHeight();
    }

    //SeekBar的拖动事件
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.e(TAG, "onStartTrackingTouch");
        isUserSeeking = true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.e(TAG, "onProgressChanged");
        Log.e(TAG, "fromUser = " + fromUser);
        //用户操作的时候不触发(重写的SeekBar不能有效的控制拖动事件，
        // 导致实际拖动时fromUser返回false，被判断不是人为滑动的。
        // 而为true的值又不是需要的值，所以增加一下判断)
        if (!isUserSeeking || fromUser) {
            return;
        }
        scrollView.scrollTo(0, progress * getScrollRange() / 50);
    }

    //SeekBar的停止拖动事件
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.e(TAG, "onStopTrackingTouch");
        isUserSeeking = false;
    }

    @Override
    public void onScrollChange(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        Log.e(TAG, "onScrollChanged :" + " x = " + x + " y = " + y + " oldx = " + oldx + " oldy = " + oldy);
        //用户触控时不触发
        if (isUserSeeking) {
            return;
        }

        int range = getScrollRange();
        Log.e(TAG, "onScrollChanged : range = " + (range != 0 ? y * 50 / range : 0));
        seekBar.setProgress(range != 0 ? y * 50 / range : 0);
    }
}