package com.wbj.algorithm.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/1/6 下午2:28
 * 描述：
 */
public interface IApi {
    @POST
    @FormUrlEncoded
    Call<LoginBean> login(@Field("count") String count,@Field("pwd") String pwd);

    @GET
    Call<LoginBean> getTest(@Path("count") String count, @Field("pwd") String pwd);
}
