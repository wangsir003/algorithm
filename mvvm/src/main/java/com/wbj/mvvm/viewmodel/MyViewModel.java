package com.wbj.mvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/2/4 下午3:16
 * 描述：
 */
public class MyViewModel extends ViewModel {
     MutableLiveData<Integer> aTeamScore; //a队的分数
    private MutableLiveData<Integer> bTeamScore; //b队的分数
    private MutableLiveData<String> mResult; //比赛结果
    private int aBack,bBack; //用于Undo操作的上一次各队分数

    //普通的Get方法
    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore == null){ //处理空指针异常
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore == null){
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }

    //加分操作，该方法通过DataBinding与按键绑定
    public void aTeamAdd(int p){
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(aTeamScore.getValue() + p);
    }

    public void bTeamAdd(int p){
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        bTeamScore.setValue(bTeamScore.getValue() + p);
    }

    //重置操作
    public void reset(){
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }
    //撤销操作
    public void undo(){
        aTeamScore.setValue(aBack);
        bTeamScore.setValue(bBack);
    }

    public MutableLiveData<String> getResult(){
        if (mResult == null){ //处理空指针异常
            mResult = new MutableLiveData<>();
        }
        if (getaTeamScore().getValue() == getbTeamScore().getValue()){
            mResult.setValue("平局");
        }else if (getaTeamScore().getValue() > getbTeamScore().getValue()){
            mResult.setValue("A领先");
        }else {
            mResult.setValue("B领先");
        }
        return mResult;

    }
}

