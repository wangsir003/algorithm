package com.wbj.algorithm.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/1/6 下午2:27
 * 描述：
 */
public class RetrofitUtil {
    public static void get(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
//                .addConverterFactory(new Factory)
                .client(okHttpClient)
                .build();
        IApi iApi = retrofit.create(IApi.class);
        iApi.login("13133","fjjf").enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {

            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {

            }
        });
    }
    public static void post(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
//                .addConverterFactory(new Factory)
                .client(okHttpClient)
                .build();
        IApi iApi = retrofit.create(IApi.class);
        iApi.login("13133","fjjf").enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {

            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {

            }
        });
    }
}
