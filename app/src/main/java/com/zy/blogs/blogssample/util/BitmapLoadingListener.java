package com.zy.blogs.blogssample.util;

import android.graphics.Bitmap;

/**
 * Created by zy on 2016/10/12.
 */
public interface BitmapLoadingListener {
    void onSuccess(Bitmap b);

    void onError();
}
