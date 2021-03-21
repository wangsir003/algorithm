package com.wbj.javatest.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/1/20 上午10:02
 * 描述：
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        final ThreadPoolExecutor service = new ThreadPoolExecutor(0,1000,10, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//        new ThreadPoolExecutor()

        for (int i = 0; i < 1000; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(300);
//                        System.out.println("tname->" + Thread.currentThread());
//                        System.out.println("t-count->" + service.getActiveCount());
//                        System.out.println("t-count->" + service.getTaskCount());
                        System.out.println("t-count->" + service.getCompletedTaskCount());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);

        }
        int activeCount = service.getActiveCount();
//        long taskCount = service.getTaskCount();
//        long completedTaskCount = service.getCompletedTaskCount();
    }


}
