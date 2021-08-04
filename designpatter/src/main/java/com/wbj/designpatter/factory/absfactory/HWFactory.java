package com.wbj.designpatter.factory.absfactory;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/3 上午10:39
 * 描述：
 */
public class HWFactory extends AbsFactoryPhoneFactory {
    @Override
    HWPhone makePhone() {
        return new HWPhone();
    }
}
