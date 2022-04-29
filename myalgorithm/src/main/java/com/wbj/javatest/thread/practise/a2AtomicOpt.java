package com.wbj.javatest.thread.practise;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/20 下午2:09
 * 描述：
 * 多个线程，计算和，保证结果正确性
 */
public class a2AtomicOpt {

    //思路1：多个线程同时进行累加
//    private static int mSum = 0;

    private static AtomicInteger mSum = new AtomicInteger(0);

    public static void main(String[] args) {
        SumRunnable sumRunnable = new SumRunnable();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(sumRunnable);
            thread.start();
        }
        while (Thread.activeCount() > 1){///有存活线程时礼让
            Thread.yield();
        }
        System.out.println("sum = " + mSum);
    }

    static class SumRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                add();
            }
        }
    }

    private static void add() {
        mSum.incrementAndGet();//累加1操作，多线程操作时只要一个
//        mSum ++;
    }

}
