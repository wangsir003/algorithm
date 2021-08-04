package com.wbj.designpatter.observer;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/4 上午10:21
 * 描述：
 */
public class TestObs {

    public static void main(String[] args) {
        SubjectSub subjectSub = new SubjectSub();
        Observer observer1 = new ObserverSub();
        Observer observer2 = new ObserverSub1();
        subjectSub.add(observer1);
        subjectSub.add(observer2);

        subjectSub.notifyObs("今天是八月四号");
    }
}
