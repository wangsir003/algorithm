package com.wbj.designpatter.instance;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/7/30 下午4:10
 * 描述：饿汉式写法
 */
public class InstanceDemo2 {

    private InstanceDemo2(){
        System.out.println("恶汉获取实例");
    }

    private static  InstanceDemo2 mInstance = new InstanceDemo2();



    /*
    *  final 的作用，防止反射修改，
    * 如果单例需要释放，则不能用final修饰
    *
    * */

    public static InstanceDemo2 getInstance(){
        return mInstance;
    }

    public void print(){
        System.out.println("饿汉式写法");
    }

}


