package com.wbj.designpatter.factory.absfactory;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/3 上午11:04
 * 描述：
 */
public class TestFactory {

    /*
    * 工厂模式通过工厂的方式去创建对象，
    * 优点：有新的对象需要创建时可以创建新的工厂，不用修改原来的工厂类，
    * 缺点：违反了开闭原则，如果工厂需要增加功能，比如手机厂增加了 造口罩，
    *
    * */

    public static void main(String[] args) {
        HWFactory hwFactory = new HWFactory();
        HWPhone iPhone = hwFactory.makePhone();

        XMFactory xmFactory = new XMFactory();
        XMPhone xmPhone = xmFactory.makePhone();
    }
}
