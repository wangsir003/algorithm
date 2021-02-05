package com.wbj.mvvm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.wbj.mvvm.databinding.ViewModelActivityBing;
import com.wbj.mvvm.viewmodel.MyViewModel;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/2/4 下午3:23
 * 描述：
 */
public class ViewModelActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context,ViewModelActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelActivityBing binding = DataBindingUtil.setContentView(this, R.layout.act_view_model);
        MyViewModel myViewModel = new ViewModelProvider.NewInstanceFactory().create(MyViewModel.class);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);

        TextView tvAddA = findViewById(R.id.tv_add_a);
        TextView tvAddB = findViewById(R.id.tv_add_b);
        TextView tvScoreA = findViewById(R.id.tv_a_score);
        TextView tvScoreB = findViewById(R.id.tv_b_score);

        tvAddA.setOnClickListener(v -> {
            myViewModel.aTeamAdd(2);
        });
        tvAddB.setOnClickListener(v -> {
            myViewModel.aTeamAdd(2);
        });



    }


}
