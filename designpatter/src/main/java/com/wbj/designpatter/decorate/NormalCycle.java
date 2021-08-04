package com.wbj.designpatter.decorate;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/3 下午5:28
 * 描述：
 */
public class NormalCycle implements ISourceImpl{
    @Override
    public void makeCycle() {
        System.out.println("普通民用自行车");
    }
}
