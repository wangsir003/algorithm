package com.tbb.vip.measure.facequestion;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/11/26 上午11:30
 * 描述：
 */
public class MyLinearLayoutRed extends LinearLayout {
    public MyLinearLayoutRed(Context context) {
        super(context);
    }

    public MyLinearLayoutRed(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayoutRed(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("--------","MyLinearLayoutRed onTouchEvent "+MyAction.getActionType(event));
        return super.onTouchEvent(event);
    }
}