package com.wbj.designpatter.factory.absfactory;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/3 上午10:02
 * 描述：
 */
public class HWPhone implements IPhone{

    @Override
    public IPhone makeUpPhone() {
        //组装华为手机
        System.out.println("华为手机摄像第一");
        return new HWPhone();
    }
}
