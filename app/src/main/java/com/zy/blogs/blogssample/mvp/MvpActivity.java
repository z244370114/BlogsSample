package com.zy.blogs.blogssample.mvp;

import android.os.Bundle;

import com.zy.blogs.blogssample.base.BaseActivity;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 14:55
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {

    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
