package com.wbj.designpatter.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/5 下午3:46
 * 描述：
 */
public class TestDynamicProxy {

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        IProxyInterface zhangsan = new Zhangsan();
//        zhangsan.proxy();
        DynamicClz dynamicClz = new DynamicClz(zhangsan);
        IProxyInterface proxyClass = (IProxyInterface) Proxy.newProxyInstance(zhangsan.getClass().getClassLoader(), zhangsan.getClass().getInterfaces(), dynamicClz);

        proxyClass.proxy();

    }
}
