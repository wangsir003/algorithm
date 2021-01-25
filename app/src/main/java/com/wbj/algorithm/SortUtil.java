package com.wbj.algorithm;

import android.util.Log;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2020/11/18 下午4:56
 * 描述：
 */
public class SortUtil {
    private SortUtil() {
    }

    /**
     * 选择排序-从小到大
     */
    public static int[] sortBySelect(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]){
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;
    }

    /**
     * 冒泡排序-从小到大
     */
    public static int[] sortByMaoPao(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) { //n - 1 次
            for (int j = 0; j < arr.length - 1 - i; j++) { //
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                printArr("maopao",arr);
            }
        }
        return arr;
    }


    /**
     * 快速排序-从小到大
     */
    public static void sortByKuaiPai(int[] arr,int startIndex,int endIndex,int centerIndex){

        if (startIndex >= endIndex){
            return;
        }else {
            if (startIndex + 1 == endIndex){
                if (arr[startIndex] < arr[endIndex]){
                    int temp = arr[startIndex];
                    arr[startIndex] = arr[endIndex];
                    arr[endIndex] = temp;
                }
                return;
            }else {
                //每次选择中间的数值再拍一次
                int centerValue = arr[centerIndex];
                int[] minArr = new int[endIndex - startIndex + 1];
                int[] maxArr = new int[endIndex - startIndex + 1];
                int minIndex = 0;
                int maxIndex= 0;
                for (int i = startIndex; i <= endIndex; i++) {
                    if (arr[i] <= centerValue){
                        minArr[minIndex] = arr[i];
                        minIndex++;
                    }else {
                        maxArr[maxIndex] = arr[i];
                        maxIndex++;
                    }
                }
                for (int i = 0; i < minIndex; i++) {
                    arr[startIndex + i] = minArr[i];
                }
                for (int i = 0; i < maxIndex; i++) {
                    arr[startIndex + minIndex + i - 1] = maxArr[i];
                }
                printArr("快排",arr);
                minArr = null;
                maxArr = null;
                sortByKuaiPai(arr,startIndex,centerIndex,(startIndex + centerIndex)/2);
                sortByKuaiPai(arr,centerIndex,endIndex,(centerIndex + endIndex)/2);
            }

        }
    }


    public static void printArr(String tag,int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int k :
                arr) {
            sb.append(k + " ");
        }
        Log.e(tag,sb.toString());
        sb = null;
    }


}
