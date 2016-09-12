package com.zy.blogs.blogssample.mvp;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 14:49
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public interface Presenter<V> {

    void attachView(V view);

    void detachView();
}
