package com.wbj.javatest.thread;


import java.util.ArrayList;
import java.util.List;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/18 上午10:09
 * 描述：通过静态代理方式实现
 */
public class RunnableProxy implements Runnable {

    private int mCounts = 10;


    public RunnableProxy() {
    }

    @Override
    public void run() {
        //通过重写run拓展Runnable
        //延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            if (mCounts > 0) {
                System.out.println(Thread.currentThread().getName() + "抢到了第" + mCounts + "张票");
                mCounts -= 1;
            } else {
                System.out.println(Thread.currentThread().getName() + "未抢到");
            }
        }
    }


    public static void main(String[] args){

        RunnableProxy runable = new RunnableProxy();
        long start = System.currentTimeMillis();

        List<Thread> arrList = new ArrayList<Thread>();
        //模拟100个人抢10张票的情况
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runable,"用户" + i + "  ");
            thread.start();
            arrList.add(thread);
        }
        long end = System.currentTimeMillis();
        //校验线程是否存活
        for (Thread t :
                arrList) {
            System.out.println(t.getName() + t.isAlive());
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("抢完票共花费时间" + (end - start));
        //校验线程是否存活
        for (Thread t :
                arrList) {
            System.out.println(t.getName() + t.isAlive());
        }
    }

}
