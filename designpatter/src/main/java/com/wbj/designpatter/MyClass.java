package com.wbj.designpatter;

import com.wbj.designpatter.builder.DialogDemo;
import com.wbj.designpatter.instance.InstanceDemo1;
import com.wbj.designpatter.instance.InstanceDemo2;
import com.wbj.designpatter.instance.InstanceDemo3;
import com.wbj.designpatter.instance.InstanceDemo4;

import java.lang.reflect.Field;

public class MyClass {

    public static void main(String[] args) {
        InstanceDemo1.getInstance().print();
        InstanceDemo2.getInstance().print();
        InstanceDemo3.getInstance().print();
        InstanceDemo4.INSTANCE.print();
        fanshe();

        new DialogDemo.Builder()
                .setTitle("我是标题")
                .setContent("我是张三")
                .build()
                .show();
    }


    /**
     * 饿汉式-不用final修饰时的问题
     * 反射修改单例,不用final 可以通过反射去修改
     */
    public static void fanshe()  {
        Class<?> aClass = InstanceDemo2.class;
        Field a = null;
        try {
            a = aClass.getDeclaredField("mInstance");
            a.setAccessible(true);
            a.set(null, null);
            System.out.println(a.get(aClass));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println();
    }


}