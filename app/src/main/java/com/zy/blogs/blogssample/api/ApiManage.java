package com.zy.blogs.blogssample.api;

import com.zy.blogs.blogssample.AppConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xinghongfei on 16/8/12.
 */
public class ApiManage {

    public static ApiManage apiManage;
    private static int cacheSize = 10 * 1024 * 1024; // 10 MiB
    private static OkHttpClient client = new OkHttpClient.Builder()
            .build();
    public LoginApi loginApi;
    private Object blogsMonitor = new Object();

    public static ApiManage getInstence() {
        if (apiManage == null) {
            synchronized (ApiManage.class) {
                if (apiManage == null) {
                    apiManage = new ApiManage();
                }
            }
        }
        return apiManage;
    }

    public LoginApi getLoginApiService() {
        if (loginApi == null) {
            synchronized (blogsMonitor) {
                if (loginApi == null) {
                    loginApi = new Retrofit.Builder()
                            .client(client)
                            .baseUrl(AppConfig.BASE_URL)
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(LoginApi.class);
                }
            }
        }
        return loginApi;
    }


}
