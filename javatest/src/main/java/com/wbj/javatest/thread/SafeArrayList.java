package com.wbj.javatest.thread;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/23 上午11:52
 * 描述：
 */
public class SafeArrayList {

    private static ArrayList<Integer> mList = new ArrayList<>();
    private static AtomicInteger mAtomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    addData();
                }
            }).start();
        }
        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    addData();
                }
            }).start();
        }
    }

    private static int size = 0;
    public static void addData(){
        mAtomicInteger.incrementAndGet();
        mList.add(size++);
        mList.remove(size);
        System.out.println("size--->" + mAtomicInteger.get());
    }


}
