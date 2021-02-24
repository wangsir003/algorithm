package com.tbb.vip.measure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch switchInt;
    private Switch switchTouchEvent;
    private Switch switchDis;
    private Switch switchDisView;
    private Switch switchTouchEventView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchDis = findViewById(R.id.switchDis);
        switchInt = findViewById(R.id.switchInt);
        switchTouchEvent = findViewById(R.id.switchTouchEvent);

        switchDisView = findViewById(R.id.switchDisView);
        switchTouchEventView = findViewById(R.id.switchTouchEventView);

        switchDis.setOnCheckedChangeListener(this);
        switchInt.setOnCheckedChangeListener(this);
        switchTouchEvent.setOnCheckedChangeListener(this);
        switchDisView.setOnCheckedChangeListener(this);
        switchTouchEventView.setOnCheckedChangeListener(this);

        TextView tvLog = findViewById(R.id.tv_log);
        View myView = findViewById(R.id.myView);
        ViewGroup myViewGroup = findViewById(R.id.myViewGroup);
        TouchLoger.getInstance().setTextView(tvLog);
//        myView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
////                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
////                    TouchLoger.getInstance().clearLog();
////                }
//                return false;
//            }
//        });

        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了myView", Toast.LENGTH_SHORT).show();
//                TouchLoger.getInstance().clearLog();
            }
        });

        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了myView", Toast.LENGTH_SHORT).show();
//                TouchLoger.getInstance().clearLog();
            }
        });
        myViewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了myViewGroup", Toast.LENGTH_SHORT).show();
//                TouchLoger.getInstance().clearLog();
            }
        });


    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isSelected) {
        if (compoundButton == switchDis){
            TouchLoger.getInstance().setDispatchOfGroup(isSelected);
        }else if (compoundButton == switchInt){
            TouchLoger.getInstance().setIntercepthOfGroup(isSelected);
        }else if (compoundButton == switchTouchEvent){
            TouchLoger.getInstance().setTouchEventOfGroup(isSelected);
        }else if (compoundButton == switchDisView){
            TouchLoger.getInstance().setDispatchOfView(isSelected);
        }else if (compoundButton == switchTouchEventView){
            TouchLoger.getInstance().setTouchEventOfView(isSelected);
        }
    }








}






















