package com.wbj.javatest.tanxin;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/6/16 下午4:04
 * 描述：
 */
public class TanXin {
    public static void main(String[] args) {

        int[] aar = new int[]{3,7,2,3};
        System.out.println(stoneGame(aar));;
    }

    public static boolean stoneGame(int[] piles) {
        int start = 0;
        int end = piles.length -1;
        int sumA = 0;
        int sumAll = 0;
        for (int i :
                piles) {
            sumAll += i;
        }
        while (start < end){
            //A取石子
            if (piles[start] >= piles[end]){
                sumA += piles[start];
                start += 1;
            }else {
                sumA += piles[end];
                end -= 1;
            }

            //B取石子
            if (start < end) {
                if (piles[start] >= piles[end]) {
                    start += 1;
                } else {
                    end -= 1;
                }
            }
        }

        return sumA > (sumAll - sumA);
    }
}
