package com.zy.blogs.blogssample.mvp;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 15:03
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public interface BaseView {

    void getDataFail(String msg);

    void showLoading();

    void hideLoading();
}
