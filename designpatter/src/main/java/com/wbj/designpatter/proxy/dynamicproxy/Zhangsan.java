package com.wbj.designpatter.proxy.dynamicproxy;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/5 下午3:42
 * 描述：
 */
public class Zhangsan implements IProxyInterface{
    @Override
    public void proxy() {
        System.out.println("我是代理接口方法");
    }
}
