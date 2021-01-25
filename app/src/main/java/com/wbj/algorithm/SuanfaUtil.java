package com.wbj.algorithm;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2020/11/2 下午4:31
 * 描述：
 */
public class SuanfaUtil {

    public SuanfaUtil() {
    }



    /**
     * 求交集
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int item : nums1) {
            for (int value : nums2) {
                if (item == value) {
                    if (result.size() == 0){
                        result.add(item);
                    }else {
                        for (int i = 0; i < result.size(); i++) {
                            if (i == result.size() - 1 && item != result.get(i)){
                                result.add(i);
                            }
                        }
                    }
                    break;
                }
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    /**
     * 计算质数
     */
    public static void primeNumber() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Long i = Integer.MAX_VALUE * 1L;
                Long max = Long.MAX_VALUE;
                while (i < max){
                    Long center = i / 2;
                    for (Long j = 2L; j <= center; j++) {
                        if (i % j == 0){
                            break;
                        }else if (j == center){
                            Log.e("质数是：","i = " + i);
                        }
                    }
                    i ++;
                }

            }
        }).start();

    }

    //给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    public static int firstUniqChar(String s){
        if (s == null || s == ""){
            return -1;
        }
        char[] chars = s.toCharArray();
        int index = 0;
        int length = s.length();
        if (length == 1){
            return 0;
        }
        while (index < length){
            char currChar = chars[index];
            for (int i = 0; i < length; i++) {
                if (currChar == chars[i] && i != index){
                    break;
                }else if (i == length - 1){
                    return index;
                }
            }
            index ++;
        }



        return -1;
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++) {
            int cha = target - nums[i];
            for(int j = 0;j < nums.length;j++) {
                if(i != j && cha == nums[j]){
                    return  new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static Long reverse(Long x) {

//        StringBuilder str = new StringBuilder(x.toString());
//        StringBuilder reverse = str.reverse();

        if (x != 0)
            while(true){
                if(x % 10 == 0){
                    x = x/10;
                }else{
                    break;
                }
            }
        boolean isLowZero = x < 0;
        if (isLowZero) x *= -1;
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int length = chars.length/2;
        for(int i = 0;i < length;i++){
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return isLowZero ? Long.parseLong(String.valueOf(chars)) * -1:Long.parseLong(String.valueOf(chars));

    }

}
