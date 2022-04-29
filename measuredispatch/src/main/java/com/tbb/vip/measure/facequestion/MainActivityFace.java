package com.tbb.vip.measure.facequestion;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tbb.vip.measure.R;
import com.tbb.vip.measure.TouchLoger;

public class MainActivityFace extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_face);
        Handler handler = new Handler();
        findViewById(R.id.red).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("--------", "touch  red  " + MyAction.getActionType(event));
                return true;
            }
        });
        findViewById(R.id.green).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("--------", "touch  green  " + MyAction.getActionType(event));
                return true;
            }
        });
        findViewById(R.id.yellow).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("--------", "touch  yelloe  " + MyAction.getActionType(event));
                return true;
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


}






















