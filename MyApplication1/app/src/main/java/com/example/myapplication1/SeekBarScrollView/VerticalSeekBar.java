package com.example.myapplication1.SeekBarScrollView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class VerticalSeekBar extends androidx.appcompat.widget.AppCompatSeekBar {
    private final String TAG = "VerticalSeekBar";

    public VerticalSeekBar(Context context) {
        super(context);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //      onDraw事件中旋转画布，与水平变垂直
    @Override
    protected synchronized void onDraw(Canvas canvas) {
        canvas.rotate(-90);
        canvas.translate(-getHeight(), 0);
        super.onDraw(canvas);
    }

    //      切记加上尺寸变更时的事件，变更对换宽高值
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    //      最后重载一下滑动事件，从新计算progress值
    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        必须写要，否则不能继承(执行)父类内容，导致开始拖动和停止拖动的监听器不在响应
        super.onTouchEvent(event);

        if (!isEnabled())
            return false;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
//                因为是向上滑动的，所以最大值乘Y轴的滑动比例得到上面的取值，实际值再用最大值减
                setProgress((int) (getMax() - getMax() * event.getY() / getHeight()));
                onSizeChanged(getWidth(), getHeight(), 0, 0);
                break;
        }
        return true;
    }

    @Override
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }

    public interface SeekBarListeren {
        void onSeekBarChange(VerticalSeekBar verticalSeekBar, int rang);
    }
}
