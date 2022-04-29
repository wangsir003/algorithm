package com.wbj.javatest;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/26 下午5:19
 * 描述：
 */
public class aaa {
    public static void main(String[] args) {
        String aa = new String("aaa");

        //对象的实例作为参数传递，是可以修改对象内容的
        Student s1 = new Student();
        s1.name = "张三";
        System.out.println("s1.name = " + s1.name);

        fix(s1);
        System.out.println("s1.name(method fix) = " + s1.name);
    }

    static class Student {
        String name;
    }

    static void fix(Student s) {
        s.name = s.name + "|学号";

    }
}
