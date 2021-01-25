package com.wbj.javatest;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// ？
public class Demo5 {
    public static void main(String[] args) {
        final ThreadUnSafe safe = new ThreadUnSafe();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    safe.method();
                }
            }, "Thread__" + i).start();
        }
    }
}

class ThreadUnSafe {
    List<String> lists = new ArrayList<>();

    public void method() {
         for (int i = 0; i < 2000; i++) {
            method1();
//             System.out.println("didid" + i);
             method2();
         }
    }

    private void method2() {
        lists.remove(0);
    }

    private void method1() {
        lists.add("1");
    }

}
