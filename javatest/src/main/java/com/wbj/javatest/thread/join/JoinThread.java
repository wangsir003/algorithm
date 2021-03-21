package com.wbj.javatest.thread.join;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/18 下午3:20
 * 描述：
 * 线程插队，会让插队线程执行完之后再执行其他线程
 */
public class JoinThread implements Runnable{
    static boolean isJoined = false;

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
//            if (isJoined){
//                System.out.println("有人插队了，大家注意了");
//                isJoined = false;
//            }
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThreadRunnable = new JoinThread();
        Thread thread1 = new Thread(joinThreadRunnable,"小明");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
//            if (isJoined){
//                System.out.println("有人插队了，大家注意了");
//                isJoined = false;
//            }
                    System.out.println(Thread.currentThread().getName() + "执行" + i);
                }
            }
        }, "郎朗");
        thread1.start();
        thread2.start();
        thread2.join();
        System.out.println("main:让郎朗插队");
//        isJoined = true;

//
//        for (int i = 0; i < 200; i++) {
//            if (i == 100){
//                System.out.println("main:让thread插队");
//                thread1.join();//插队，先执行thread1执行完再执行
//            }
//            System.out.println("main:" + i);
//        }

    }
}
