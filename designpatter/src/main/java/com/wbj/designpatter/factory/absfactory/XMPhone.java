package com.wbj.designpatter.factory.absfactory;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/3 上午10:02
 * 描述：
 */
public class XMPhone implements IPhone{

    @Override
    public IPhone makeUpPhone() {
        //组装小米手机
        return new XMPhone();
    }
}
