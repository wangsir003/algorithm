package com.wbj.designpatter.factory.simple;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/2 下午3:43
 * 描述：
 */
public class RussiaShip implements SpaceShapeInterface{

    @Override
    public SpaceShapeInterface build() {
        return new RussiaShip();
    }
}
