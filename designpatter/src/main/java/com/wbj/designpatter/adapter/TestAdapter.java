package com.wbj.designpatter.adapter;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/3 下午4:05
 * 描述：
 */
public class TestAdapter {

    public static void main(String[] args) {

        /*
        * 使用的前提：
1．接口中规定了所有要实现的方法
2．但一个要实现此接口的具体类，只用到了其中的几个方法，而其它的方法都是没有用的。

        *
        *
        * */

        ILivePlayer compress = new LivePlayer("qiniu");
        compress.QnPlayer();
//        compress.pressFile();
//
//        System.out.println("--------扩展之后的适配器类--------");
//        AdapterCompress adapterCompress = new AdapterCompress();
//        adapterCompress.pressFile();
//        adapterCompress.depressFile();
    }
}
