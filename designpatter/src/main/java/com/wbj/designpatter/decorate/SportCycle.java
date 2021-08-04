package com.wbj.designpatter.decorate;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/3 下午5:28
 * 描述：
 */
public class SportCycle implements ISourceImpl{
    NormalCycle normalCycle = null;

    public SportCycle(NormalCycle normalCycle) {
        this.normalCycle = normalCycle;
    }

    @Override
    public void makeCycle() {
        normalCycle.makeCycle();
        System.out.println("把民用版自行车升级为运动版");
    }
}
