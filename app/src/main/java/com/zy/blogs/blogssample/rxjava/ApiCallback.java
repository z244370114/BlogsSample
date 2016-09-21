package com.zy.blogs.blogssample.rxjava;


import com.zy.blogs.blogssample.model.ErrModel;

/**
 * Created by oliver on 16/5/7.
 */
public interface ApiCallback<T> {

    void onSuccess(T data);

    void onFailure(int code, String msg, ErrModel errData);

    void onCompleted();


}
