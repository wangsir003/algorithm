package com.tbb.vip.measure;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Create By WangSir on 2021/1/25 0025
 */
public class MyViewGroup extends FrameLayout {

    private String TAG = "MyViewGroup";

    public MyViewGroup(@NonNull Context context) {
        super(context);
    }

    public MyViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN){
            TouchLoger.getInstance().clearLog();
        }
        TouchLoger.getInstance().logE(TAG,"dispatchTouchEvent",ev,TouchLoger.getInstance().isDispatchOfGroup());
        super.dispatchTouchEvent(ev);
        return TouchLoger.getInstance().isDispatchOfGroup();
//        boolean isDis = super.dispatchTouchEvent(ev);

//        Log.e(TAG,"dispatchTouchEvent---->" + isDis);
//        return isDis;

    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        TouchLoger.getInstance().logE(TAG,"onInterceptTouchEvent",ev,TouchLoger.getInstance().isIntercepthOfGroup());
        return TouchLoger.getInstance().isIntercepthOfGroup();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        TouchLoger.getInstance().logE(TAG,"onTouchEvent",event,TouchLoger.getInstance().isTouchEventOfGroup());
        super.onTouchEvent(event);
        return TouchLoger.getInstance().isTouchEventOfGroup();

    }
}
