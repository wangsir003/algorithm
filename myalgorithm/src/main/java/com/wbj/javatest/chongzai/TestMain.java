package com.wbj.javatest.chongzai;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2022/4/25 下午3:30
 * 描述：
 */
public class TestMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.test();

        int a = 1;
        int b = 1;
        System.out.println("a = " + add(a));
        System.out.println("b = " + (add2(b) + 1));

    }


    static int add(int i){
        return ++i;
    }

    static int add2(int i){
        return i++;
    }
}
