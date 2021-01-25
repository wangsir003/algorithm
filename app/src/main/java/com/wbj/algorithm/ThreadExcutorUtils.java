package com.wbj.algorithm;

import android.os.Looper;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2020/12/24 上午9:53
 * 描述：
 */
public class ThreadExcutorUtils {
    public static String TAG = "ThreadExcutorUtils";

    public static void initPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    boolean mainThread = isMainThread();
//                    Log.e(TAG,mainThread + "");
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e(TAG,Thread.currentThread() + "");
                }
            });
        }


    }

    public static boolean isMainThread(){
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
