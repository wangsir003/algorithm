package com.tbb.vip.measure;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Create By WangSir on 2021/1/25 0025
 */
public class MyView extends View {

    private String TAG = "MyView";

    public MyView(@NonNull Context context) {
        super(context);
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        TouchLoger.getInstance().logE(TAG,"dispatchTouchEvent",ev);

        return TouchLoger.getInstance().isDispatchOfView();
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        TouchLoger.getInstance().logE(TAG,"MotionEvent",event);
        return TouchLoger.getInstance().isTouchEventOfView();
    }


}
