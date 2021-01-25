package com.wbj.algorithm.layoutinflate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.wbj.algorithm.R;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/1/15 上午9:57
 * 描述：
 */
public class LayoutInflateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_layoutinflate);
        LinearLayout rootView = findViewById(R.id.cl_root);
        rootView.removeAllViews();
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_inflate_test, rootView, false);
        rootView.addView(inflate);

    }
}
