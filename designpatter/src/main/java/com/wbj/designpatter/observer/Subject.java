package com.wbj.designpatter.observer;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/4 上午10:10
 * 描述：订阅接口 ，用于添加删除
 */
public interface Subject {
    void add(Observer observer);
    void del(Observer observer);
    void notifyObs(String msg);
}
