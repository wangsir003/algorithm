package com.wbj.javatest.thread.practise;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/19 下午1:58
 * 描述：
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 一个将会调用 first() 方法
 * 一个将会调用 second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class a1PrintByOrder {
    private static AtomicInteger firstJobDone = new AtomicInteger(0);
    private static AtomicInteger secondJobDone = new AtomicInteger(0);

    public a1PrintByOrder() {}

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            boolean flag = false;
            @Override
            public void run() {
                try {
                    if (!flag) {
                        System.out.println(this);
                        first(this);
                        flag = true;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            boolean flag = false;

            @Override
            public void run() {
                try {
                    if (!flag) {
                        second(this);
                        flag = true;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
        Thread thread3 = new Thread(new Runnable() {
            boolean flag = false;

            @Override
            public void run() {
                try {
                    if (!flag) {
                        third(this);
                        flag = true;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();
    }


    public static void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public static void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public  static void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }
}
