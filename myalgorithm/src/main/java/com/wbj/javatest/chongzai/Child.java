package com.wbj.javatest.chongzai;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2022/4/25 上午10:47
 * 描述：
 */
public class Child extends Parent implements IBTest{

    public void writeSome(String some) {

    }


    public void writeSome(String some, String some1) {

    }

    public String writeSome(String some, String some1, String some2) {
        return "some = " + some + some1 + some2;
    }

    @Override
    public void test() {

    }
}
