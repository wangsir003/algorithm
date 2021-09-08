package com.wbj.designpatter.proxy.staticprox;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/9 上午11:44
 * 描述：
 */
public class StarProxy implements IStarImpl {

    @Override
    public void playMV() {
        System.out.println("明星演戏，");
    }
}
