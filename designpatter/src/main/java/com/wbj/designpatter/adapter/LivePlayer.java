package com.wbj.designpatter.adapter;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/8/4 下午5:50
 * 描述：
 */
public class LivePlayer implements ILivePlayer{

    ILivePlayer iLivePlayer = null;

    public LivePlayer(String playType) {
        if ("qiniu".equals(playType)){
            iLivePlayer = new QnPlayer();
        }else if ("tencent".equals(playType)){
            iLivePlayer = new TxPlayer();
        }
    }

    @Override
    public void QnPlayer() {
        iLivePlayer.QnPlayer();
    }

    @Override
    public void TxPlayer() {
        iLivePlayer.TxPlayer();
    }
}
