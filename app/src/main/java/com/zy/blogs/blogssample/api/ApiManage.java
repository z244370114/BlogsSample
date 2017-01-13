package com.zy.blogs.blogssample.api;

import com.zy.blogs.blogssample.BuildConfig;
import com.zy.blogs.blogssample.util.BasicParamsInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.blankj.utilcode.utils.EncryptUtils.encryptSHA1ToString;

/**
 * Created by xinghongfei on 16/8/12.
 */
public class ApiManage {

    public static ApiManage apiManage;
    private static int cacheSize = 10 * 1024 * 1024; // 10 MiB
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
    public static Retrofit mRetrofit1;

    public static Retrofit retrofit() {
        if (mRetrofit == null) {
            synchronized (blogsMonitor) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
//                // Log信息拦截器
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//                //设置 Debug Log 模式
                    builder.addNetworkInterceptor(loggingInterceptor);
//                    builder.addInterceptor(loggingInterceptor);
                }
                OkHttpClient okHttpClient = builder.build();
                mRetrofit = new Retrofit.Builder()
                        .baseUrl(ApiStores.BASE_URL1)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(okHttpClient)
                        .build();
            }
        }
        return mRetrofit;
    }

    public static Retrofit retrofit1() {
        if (mRetrofit1 == null) {
            synchronized (blogsMonitor) {
//                Map<String, String> headerParamsMap = new HashMap<>();
                String time = Long.toString(System.currentTimeMillis() / 1000);
                String tsp = encryptSHA1ToString(time + "ziw92x83j2xi9xlw").toLowerCase();
//                headerParamsMap.put("User-Agent", "deyihome-android-client-v1-k95dmxmj7e");
//                headerParamsMap.put("Accept", "application/json");
                BasicParamsInterceptor basicParamsInterceptor =
                        new BasicParamsInterceptor.Builder()
                                .addHeaderParam("User-Agent", "deyihome-android-client-v1-k95dmxmj7e")
                                .addHeaderParam("Accept", "application/json")
                                .addParam("_t", time)
                                .addParam("_tsp", tsp)
                                .build();

                OkHttpClient.Builder builder = new OkHttpClient.Builder();
//                // Log信息拦截器
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//                //设置 Debug Log 模式
                    builder.addNetworkInterceptor(loggingInterceptor);
                    builder.addInterceptor(basicParamsInterceptor);
                    builder.addInterceptor(loggingInterceptor);
                }
                OkHttpClient okHttpClient = builder.build();
                mRetrofit1 = new Retrofit.Builder()
                        .baseUrl(ApiStores.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
//                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(okHttpClient)
                        .build();
            }
        }
        return mRetrofit1;
    }

}
