package com.tbb.vip.measure.facequestion;

import android.view.MotionEvent;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/11/26 上午11:28
 * 描述：
 */
public class MyAction {

    public static String getActionType(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";
            default:
                return "";
        }
    }
}
