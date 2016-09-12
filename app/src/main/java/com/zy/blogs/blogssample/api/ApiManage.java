package com.zy.blogs.blogssample.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
    //    public LoginApi loginApi;
    private static Object blogsMonitor = new Object();

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


    public static Retrofit mRetrofit;

    public static Retrofit retrofit() {
        if (mRetrofit == null) {
            synchronized (blogsMonitor) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
//                // Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor);

                OkHttpClient okHttpClient = builder.build();
                mRetrofit = new Retrofit.Builder()
                        .baseUrl(ApiStores.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(okHttpClient)
                        .build();
            }
        }
        return mRetrofit;
    }

}
