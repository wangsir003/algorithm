package com.wbj.javatest.thread.stop;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/18 下午3:20
 * 描述：
 * 停止线程的几种方式
 */
public class StopThread implements Runnable{

    private static boolean flag = false;//true时停止
    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            if (flag) {
                break;
            }else{
                System.out.println("不断打印");
            }
        }
    }

    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        Thread thread = new Thread(stopThread);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("线程是否存活" + thread.isAlive());

        flag = true;
        //一秒后调用stop,查看线程的状态
//        thread.stop();
        thread.destroy();
//        thread.interrupt();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程是否存活" + thread.isAlive());
    }
}
