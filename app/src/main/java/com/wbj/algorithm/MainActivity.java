package com.wbj.algorithm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wbj.algorithm.layoutinflate.LayoutInflateActivity;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2020/11/18 下午5:07
 * 描述：
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        findViewById(R.id.tv_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LayoutInflateActivity.class));
            }
        });
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{1, 2};
//        val arr = SuanfaUtil.intersection(nums1, nums2)
//        for (i in arr.indices) {
//            Log.e("交集：", arr[i].toString() + "")
//        }


        int[] arr = new int[10];
        for (int i = 0;i < 10 ;i++){
            arr[i] = (int) (Math.random() * 10);
        }


        for (int value : arr) {
            Log.e("sort-un->", value + "");
        }


        int[] result = SortUtil.sortBySelect(arr);
        for (int value : result) {
            Log.e("sort-already->", value + "");
        }

        int[] maoPao = SortUtil.sortByMaoPao(new int[]{6,5, 4, 3, 2,1});
        for (int value : maoPao) {
            Log.e("sort-maopao->", value + "");
        }

        int[] kuaipai = new int[]{7,6,5, 4, 3, 2,1};
        SortUtil.sortByKuaiPai(kuaipai,0,kuaipai.length - 1,(kuaipai.length - 1) % 2 == 1 ?(kuaipai.length-2)/2:(kuaipai.length-1)/2);



        int[] minArr = new int[10];
        for (int in :
                minArr) {
            Log.e("数组默认值", in + "");
        }

        SuanfaUtil.primeNumber();

//        new Thread(){
            for (int i = 0; i < 10; i++) {
                long start = System.currentTimeMillis();
                StringBuffer str = new StringBuffer();//提升几千倍效率
//                String str = "";
                for (int j = 0; j < 100000; j++) {
                    str.append("a");
                }
                long end = System.currentTimeMillis();

                Log.e("耗时时长"+i,"" + (end - start));
            }
            /*
            * 那StringBuilder中数组的初始长度是多少呢?扩容系数是多少呢?
            数组默认的初始长度是16,也可以根据构造方法指定
            扩容系数: value.length * 2 + 2,而且只有当append是数据长度+value.count > value.length时才会扩容一次,
            * 不会每次都扩容去调用Arrays.copyof()
            * */
//        }.start();

        int firstUniqChar1 = SuanfaUtil.firstUniqChar(null);
        int firstUniqChar2 = SuanfaUtil.firstUniqChar("1");
        int firstUniqChar3 = SuanfaUtil.firstUniqChar("123");
        int firstUniqChar4 = SuanfaUtil.firstUniqChar("123452671");
        int firstUniqChar5 = SuanfaUtil.firstUniqChar("aadadaad");
        Log.e("firstUniqChar1",firstUniqChar1 + "");
        Log.e("firstUniqChar2",firstUniqChar2 + "");
        Log.e("firstUniqChar3",firstUniqChar3 + "");
        Log.e("firstUniqChar4",firstUniqChar4 + "");
        Log.e("firstUniqChar5",firstUniqChar5 + "");

//        Log.e("reverse",SuanfaUtil.reverse(1534236469) + "");
        ThreadExcutorUtils.initPool();

        Handler  handler = new  Handler();
        handler.sendEmptyMessage(1);

    }
}
