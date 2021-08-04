package com.wbj.designpatter.builder;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/3 下午2:56
 * 描述：
 */
public class TestBuilder {

    /*
    * 构建者模式分析：
    * 适用场景：链式调用的地方，比如：dialog，分享弹框等
    * 优点，利用静态内部类的方式去创建对象，链式调用比较方便
    * 缺点，违反开闭原则，比如添加一个属性
    * */
    public static void main(String[] args) {
        new DialogDemo
                .Builder()
                .setTitle("我是标题")
                .setContent("我是张三")
                .build()
                .show();

    }
}
