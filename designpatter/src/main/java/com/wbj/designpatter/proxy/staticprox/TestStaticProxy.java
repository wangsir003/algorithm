package com.wbj.designpatter.proxy.staticprox;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/9 上午11:57
 * 描述：
 */
public class TestStaticProxy {

    public static void main(String[] args) {

        StarProxy starProxy = new StarProxy();
        TiShen tiShen = new TiShen(starProxy);
        tiShen.playMV();
    }
}
