package com.wbj.designpatter.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/4 上午10:09
 * 描述：
 */
public class SubjectSub implements Subject{

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void del(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObs(String msg) {
        for (Observer observer:
             observerList) {
            observer.update(msg);
        }
    }
}
