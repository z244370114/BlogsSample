package com.zy.blogs.blogssample.rxjava;


/**
 * Created by oliver on 16/5/7.
 */
public interface ApiCallback<T> {

    void onSuccess(T data);

    void onFailure(int code, String msg);

    void onCompleted();

}
