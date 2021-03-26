package com.wbj.javatest;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/26 下午2:43
 * 描述：
 */
public class jvm {
    public static void main(String[] args) {
        String str = new String("abc");
        char[] aar = new char[]{'j','k','m'};
        change(str,aar);
        System.out.println(str + "----" + aar);
        System.out.println(str + "----" + aar[0] + aar[1] + aar[2]);
    }

    private static void change(String str, char[] aar) {
        str = "124";
        aar[0] = 'p';
    }
}
