package com.wbj.designpatter.instance;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/7/30 下午4:10
 * 描述：静态内部类的写法
 */
public class InstanceDemo3 {

    private InstanceDemo3() {
        System.out.println("静态内部类的写法");
    }

    private static class Instance {
        private static InstanceDemo3 mInstance = new InstanceDemo3();
    }

    /*
     *  1）为什么这样实现就是单例的？
                 因为这个类的实例化是靠静态内部类的静态常量实例化的。
                 INSTANCE 是常量，因此只能赋值一次；它还是静态的，因此随着内部类一起加载。
        （2）这样实现有什么好处？
                  我记得以前接触的懒汉式的代码好像有线程安全问题，需要加同步锁才能解决。
                  采用静态内部类实现的代码也是懒加载的，只有第一次使用这个单例的实例的时候才加载；
                   同时不会有线程安全问题
     *
     * */

    public static InstanceDemo3 getInstance() {
        return Instance.mInstance;
    }

    public void print() {
        System.out.println("静态内部类的写法");
    }

}


