package com.wbj.designpatter.factory.simple;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/2 下午3:36
 * 描述：简单工厂：又叫做静态工厂方法模式，不属于23种GOF设计模式之一。
 * 是由一个工厂对象决定创建出哪一种产品类的实例。实质是由一个工厂类根据传入的参数，
 * 动态决定应该创建哪一个产品类（这些产品类继承自一个父类或接口）的实例。
 *
 */
public class SimpleFactory {

    public static SpaceShapeInterface getShipByCountry(String country){
        if ("russia".equals(country)){
            return new RussiaShip();
        }else if ("usa".equals(country)){
            return new USAShip();
        }
        return null;
    }

    public static void main(String[] args) {
        SpaceShapeInterface russiaShip = getShipByCountry("russia");
        SpaceShapeInterface usaShip = getShipByCountry("usa");
    }

}
