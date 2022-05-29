package com.wbj.designpatter.instance;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/7/30 下午4:10
 * 描述：懒汉式
 */
public class InstanceDemo1 {

    private InstanceDemo1(){}

    // 懒汉式写法：私有构造方法 ，双重空校验 + synchronized ，及volatile 修饰，避免原子性操作
    /*
    volatile 作用:
    1、保证内存可见性：通俗来说就是，线程A对一个volatile变量的修改，对于其它线程来说是可见的，即线程每次获取volatile变量的值都是最新的。
    当一个变量被 volatile 修饰时，任何线程对它的写操作都会立即刷新到主内存中，
    并且会强制让缓存了该变量的线程中的数据清空，必须从主内存重新读取最新数据。
    2、禁止指令重排序
    禁止指令重排序的原因：JMM是允许编译器和处理器对指令重排序的，但是规定了as-if-serial语义，程序的执行结果不能改变

volatile并不能保证原子性：volatile只能保证他们操作的i是同一块内存，但依然可能出现写入脏数据的情况。

volatile适用于：对变量的写操作不依赖当前值，如多线程下执行a++，是无法通过volatile保证结果准确性的



    * ①
     *
    *
    *
    *
    * */

    private static volatile InstanceDemo1 mInstance;

    public static InstanceDemo1 getInstance(){
        if (mInstance == null){
            synchronized (InstanceDemo1.class){
                if (mInstance == null){
                    mInstance = new InstanceDemo1();
                }
            }
        }
        return mInstance;
    }

    public void print(){
        System.out.println("懒汉式");
    }

}


