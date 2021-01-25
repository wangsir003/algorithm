package com.tbb.vip.measure;

import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Create By WangSir on 2021/1/25 0025
 */
public class TouchLoger {
    private static TouchLoger logger = new TouchLoger();

    private TouchLoger(){}

    public static TouchLoger getInstance(){
        return logger;
    }

    private boolean isDispatchOfGroup = true;
    private boolean isIntercepthOfGroup = true;
    private boolean isTouchEventOfGroup = true;

    private boolean isDispatchOfView = true;
    private boolean isTouchEventOfView = true;

    private StringBuilder sb = new StringBuilder();


    public TouchLoger getLogger() {
        return logger;
    }

    public void setLogger(TouchLoger logger) {
        this.logger = logger;
    }

    public boolean isDispatchOfGroup() {
        return isDispatchOfGroup;
    }

    public void setDispatchOfGroup(boolean dispatchOfGroup) {
        isDispatchOfGroup = dispatchOfGroup;
    }

    public boolean isIntercepthOfGroup() {
        return isIntercepthOfGroup;
    }

    public void setIntercepthOfGroup(boolean intercepthOfGroup) {
        isIntercepthOfGroup = intercepthOfGroup;
    }

    public boolean isTouchEventOfGroup() {
        return isTouchEventOfGroup;
    }

    public void setTouchEventOfGroup(boolean touchEventOfGroup) {
        isTouchEventOfGroup = touchEventOfGroup;
    }

    public boolean isDispatchOfView() {
        return isDispatchOfView;
    }

    public void setDispatchOfView(boolean dispatchOfView) {
        isDispatchOfView = dispatchOfView;
    }

    public boolean isTouchEventOfView() {
        return isTouchEventOfView;
    }

    public void setTouchEventOfView(boolean touchEventOfView) {
        isTouchEventOfView = touchEventOfView;
    }

    public void clearLog(){
        sb.delete(0,sb.length());
    }

    public void logE(String TAG, String method, MotionEvent event){
        sb.append(TAG);
        sb.append("--");
        sb.append(method);
        sb.append("--");
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                sb.append("DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                sb.append("MOVE");
                break;
            case MotionEvent.ACTION_UP:
                sb.append("UP");
                break;
        }
        sb.append("\n");
        tvLog.setText(sb);
    }

    private TextView tvLog;
    public void setTextView(TextView tvLog) {
        this.tvLog = tvLog;

    }
}
