package com.wbj.designpatter.proxy.staticprox;

import com.wbj.designpatter.decorate.ISourceImpl;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/9 上午11:51
 * 描述：
 */
public class TiShen implements IStarImpl {

    StarProxy starProxy = null;

    public TiShen(StarProxy starProxy) {
        this.starProxy = starProxy;
    }

    @Override
    public void playMV() {
        System.out.println("替身接管危险动作");
        starProxy.playMV();
        System.out.println("替身完成危险动作");
    }
}
