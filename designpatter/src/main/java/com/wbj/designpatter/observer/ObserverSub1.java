package com.wbj.designpatter.observer;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/4 上午10:09
 * 描述：
 */
public class ObserverSub1 implements Observer{
    @Override
    public void update(String msg) {
        System.out.println("sub1接收到更新通知" + msg);
    }
}
