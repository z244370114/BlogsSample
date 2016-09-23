package com.zy.blogs.blogssample;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by xinghongfei on 16/8/12.
 */
public class MyApplication extends Application {

    public static MyApplication myApplication;
    public static Context context;
    public static int screenWidth;
    public static int screenHeight;
    public static int screenDpi;
    public static float screenDensity;

    public static Application getInstance() {

        return myApplication;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        context = getApplicationContext();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels; // 屏幕宽（像素，如：480px）
        screenHeight = dm.heightPixels; // 屏幕高（像素，如：800px）
        screenDpi = dm.densityDpi;
        screenDensity = dm.density;
    }

    /**
     * @return 返回context 全局都能用 context
     */
    public static Context getContext() {
        return context;
    }

}
