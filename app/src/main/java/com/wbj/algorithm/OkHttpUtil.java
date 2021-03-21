package com.wbj.algorithm;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/1/6 上午10:19
 * 描述：
 */
public class OkHttpUtil {
    public static void getOkHttp(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .addHeader("","")
                .build();
//        Call call = new Call
        try {
            Response execute = okHttpClient.newCall(request).execute();
            execute.body().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //TODO:子线程
            }
        });

    }
    public static void post(){
        OkHttpClient okHttpClient = new OkHttpClient();
        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        RequestBody requestBody = new FormBody(keys,values);
        Request request = new Request.Builder()
                .post(requestBody)
                .addHeader("","")
                .build();
//        Call call = new Call
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //TODO:子线程
            }
        });

    }
}
