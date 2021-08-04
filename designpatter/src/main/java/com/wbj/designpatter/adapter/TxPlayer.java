package com.wbj.designpatter.adapter;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/4 下午5:24
 * 描述：
 */
public class TxPlayer implements ILivePlayer{
    @Override
    public void QnPlayer() {

    }

    @Override
    public void TxPlayer() {
        System.out.println("只会播放腾讯视频");
    }
}
