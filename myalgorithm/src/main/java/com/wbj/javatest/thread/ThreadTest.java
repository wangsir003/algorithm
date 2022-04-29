package com.wbj.javatest.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/1/8 下午3:38
 * 描述：
 */
public class ThreadTest {

public static void unpark(){
    LockSupport.unpark(Thread.currentThread());
}

    public static void main(String[] args) {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111111111");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                unpark();
                System.out.println("1111111112");
            }
        });
        a.start();
        System.out.println("是否存活" + a.isAlive());
//        LockSupport.park();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            a.join();
//            a.wait();
//            LockSupport.unpark(Thread.currentThread());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("是否存活" + a.isAlive());

        System.out.println("1111111113");
//
//        TicketRunnable ticketRunnable1 = new TicketRunnable();
//        TicketRunnable ticketRunnable2 = new TicketRunnable();
//        TicketRunnable ticketRunnable3 = new TicketRunnable();
//        TicketRunnable ticketRunnable4 = new TicketRunnable();
//        List<TicketRunnable> dequeList = new ArrayList<>();
////        new ScheduledExecutorService();
//        dequeList.add(ticketRunnable1);
//        dequeList.add(ticketRunnable2);
//        dequeList.add(ticketRunnable3);
//        dequeList.add(ticketRunnable4);
//
//        LinkedBlockingDeque<Runnable> runnables = new LinkedBlockingDeque<>();
//        runnables.add(ticketRunnable1);
//        runnables.add(ticketRunnable2);
//        runnables.add(ticketRunnable3);
//        runnables.add(ticketRunnable4);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS,runnables);
//
//        for (int i = 0; i < 10; i++) {
//            threadPoolExecutor.execute(dequeList.get((int) (Math.random() * 3)));
//        }
    }

    public static class TicketRunnable implements Runnable{
        static int count = 1000;
        @Override
        public void run() {
            synchronized (this) {
                while (count > 0) {//有票时就开始抢票
                    count--;
                    try {
//                        Thread thre = Thread();
//                        thre.join();
                        Thread.sleep((long) (Math.random() * 100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "-->" + count);
                }
            }
        }
    }

}
