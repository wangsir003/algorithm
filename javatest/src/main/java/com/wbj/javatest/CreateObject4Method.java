package com.wbj.javatest;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/1/9 上午10:23
 * 描述：
 */
public class CreateObject4Method {
    //创建对象的方式
    //1 new
    //2 反射的方式，newInstance（）
    //3 clone 要实现Cloneable 接口
    //4
    public static void main(String[] args) {
        List<String > stringList = new ArrayList<>();

        A a = new A(stringList);
        try {
            A clone = (A) a.clone();
            //TODO:不重写clone（）方法，默认拷贝出来的变量和被拷贝的变量是一样的，地址都一样
            //TODO:如需深拷贝 ，则需自己实现clone
            System.out.println("clone == byclone" + (a == clone));
            System.out.println("clone.s == byclone.s" + (a.list == clone.list));
            for (int i = 0; i < 10; i++) {
                clone.list.add("" + i);
            }
            for (String str:
                a.list) {
                System.out.println(str);
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            A a1 = A.class.newInstance();
            A a2 = (A) Class.forName("com.wbj.javatest.CreateObject4Method.A").newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private A createByClass(Class<A> clas) throws IllegalAccessException, InstantiationException {
        return clas.newInstance();
    }

    public static class A implements Cloneable{

        public A(){

        }

        private String s = "";
        private List<String> list = null;

        public A(String s) {
            this.s = s;
        }

        public A(List<String> list) {
            this.list = list;
        }

        //必须实现Cloneable接口
        @Override
        protected Object clone() throws CloneNotSupportedException {
            A clone = (A) super.clone();
            clone.list = new ArrayList<>();

            return clone;

        }
    }
}
