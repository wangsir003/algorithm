package com.wbj.javatest;


import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class MainClass {
    public static void main(String[] args) {
        int tt1 = 2;
        System.out.println("x->" + ~tt1);
        int tt2 = -2;
        System.out.println("x->" + ~tt2);
        int tt3 = 0;
        System.out.println("x->" + ~tt3);

//        int tt4 = -2;
//        System.out.println("x->" + ~tt4);
//        int tt5 = 0;
//        System.out.println("x->" + ~tt5);
//        int tt7 = 0;
//        System.out.println("x->" + ~tt7);

        Father father = new Child();
//        Child father = new Child();
        System.out.println("x->" + father.x);
        int firtst = -2147483648;
        int firtst2 = -2147483648 * -1;


        byte b = 127;
        System.out.println("byte-sum = " + (b + 1));


        System.out.println("result->" + -2147483600 * -2);
        System.out.println("reverse->" + reverse(-2147483600));
        int[][] account = {{1,2,3},{2,3,4}};
        System.out.println("reverse->" + findMax(account));

        int[] res =  numsSum(new int[]{1,2,3,4});
        for (int sum :
                res) {
            System.out.println("item-sum->" + sum);

        }
        StringBuilder sb = new StringBuilder();


        int[][] twoarr = new int[][]{{1,1},{3,4},{-1,0}};
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        int xx = numberOfMatches(7);
    }
    public static int numberOfMatches(int n) {
        int times = 0;
        int winers = n;
        while(winers > 1){
            if(winers % 2 == 0){
                winers /= 2;
                times += winers;
            }else{
                times += (winers - 1)/2;
                winers =  (winers - 1)/2 + 1;
            }
        }
        return times;

    }

    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    private static boolean has(List<Integer> arr,int num){
        for(int curr :arr){
            return curr == num;
        }
        return false;
    }

    public static int[] numsSum(int[] nums){
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                result[i] += nums[j];
            }
        }

        return result;
    }

    public static int findMax(int[][] accounts){
        int max = 0;
        int temp = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                temp +=accounts[i][j];
            }
            if (max < temp){
                max = temp;
            }
            temp = 0;
        }
        return max;
    }

    public static int reverse(int x) {
        if (x != 0)
            while(true){
                if(x % 10 == 0){
                    x = x/10;
                }else{
                    break;
                }
            }
        Long tempX = Integer.toUnsignedLong(x);
        if (x < 0) {//TODO:形式参数不能改变其值
            tempX = -1L * x;
        }
        String str = String.valueOf(tempX);
        char[] chars = str.toCharArray();
        int length = chars.length/2;
        for(int i = 0;i < length;i++){
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        Long result = Long.parseLong(String.valueOf(chars));

        if (result > Integer.MAX_VALUE){
            return 0;
        }else {
            return x < 0 ? (int)(result *-1): result.intValue();
        }

    }
}


class Father{
    int x = 10;
    public Father(){
        this.print();
        x = 20;
    }

    public void print() {
        System.out.println("x->father" + x);
    }
}
class Child extends Father{
    int x = 30;
    public Child(){
        this.print();
        x = 40;
    }

    public void print() {
        System.out.println("x->son" + x);
    }
}
