package com.wbj.designpatter.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/5 下午3:42
 * 描述：
 */
public class DynamicClz implements InvocationHandler {

    private IProxyInterface zhangsan = null;

    public DynamicClz(IProxyInterface zhangsan) {
        this.zhangsan = zhangsan;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {

        System.out.println("Before invoke " + method.getName());
        Object obj = method.invoke(zhangsan, args);
        System.out.println("After invoke " + method.getName());
        return obj;
    }
}
