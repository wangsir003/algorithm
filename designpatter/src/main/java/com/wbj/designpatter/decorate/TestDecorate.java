package com.wbj.designpatter.decorate;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/3 下午5:29
 * 描述：
 */
public class TestDecorate {

    /*
    * 适用场景：扩展原接口实现类的方法，而且扩展之后有通用性，
    * 比如：某个类的某个方法在使用时前后都有一大堆代码就可以用装饰模式
    * 优点：不用修改原来的代码就能扩展，
    *
    *
    * */
    public static void main(String[] args) {

        NormalCycle normalCycle = new NormalCycle();
        SportCycle sportCycle = new SportCycle(normalCycle);
        sportCycle.makeCycle();
    }
}
