package com.wbj.javatest.thread;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/18 下午2:39
 * 描述：通过集成Thread实现
 */
public class ThreadExtend extends Thread{

    @Override
    public void run() {
        System.out.println("打印run方法");
    }

    public static void main(String[] args) {
        ThreadExtend t = new ThreadExtend();
        t.start();
    }
}
