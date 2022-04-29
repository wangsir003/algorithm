package com.wbj.javatest.thread;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/26 下午4:15
 * 描述：
 */
public class InstanceUtil {
    private InstanceUtil(){}
    private static InstanceUtil mInstanceUtil = null;

    public static InstanceUtil getInstanceUtil(){
        if (mInstanceUtil == null){
            synchronized (InstanceUtil.class){
                if (mInstanceUtil == null){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mInstanceUtil = new InstanceUtil();
                }
            }
        }
        return mInstanceUtil;
    }

    public void log(String msg){
        System.out.println(msg);
    }
}
