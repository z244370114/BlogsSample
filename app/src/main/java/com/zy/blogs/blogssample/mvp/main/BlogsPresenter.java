package com.zy.blogs.blogssample.mvp.main;

import com.zy.blogs.blogssample.model.ErrModel;
import com.zy.blogs.blogssample.model.GankModel;
import com.zy.blogs.blogssample.mvp.BasePresenter;
import com.zy.blogs.blogssample.rxjava.ApiCallback;
import com.zy.blogs.blogssample.rxjava.SubscriberCallBack;

/**
 * <p/>
 * 作者：zhouyuan on  2016/10/11 15:14
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public class BlogsPresenter extends BasePresenter<BlogsView> {


    public BlogsPresenter(BlogsView blogsView) {
        attachView(blogsView);
    }

    public void loadData(int number, int page) {
        mvpView.showLoading();
        addSubscription(apiStores.loadAndroidData(number, page),
                new SubscriberCallBack<>(new ApiCallback<GankModel>() {
                    @Override
                    public void onSuccess(GankModel data) {
                        mvpView.loadData(data);
                    }

                    @Override
                    public void onFailure(int code, String msg, ErrModel errData) {
                        String message = errData.getError().getMessage();
                        mvpView.getDataFail(message);
                    }

                    @Override
                    public void onFailure(int code, String msg) {

                        mvpView.getDataFail(msg);
                    }

                    @Override
                    public void onCompleted() {
                        mvpView.hideLoading();
                    }
                }));
    }
}
