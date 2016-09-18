package com.zy.blogs.blogssample.mvp.main;

import com.zy.blogs.blogssample.model.UserModel;
import com.zy.blogs.blogssample.mvp.BasePresenter;
import com.zy.blogs.blogssample.rxjava.ApiCallback;
import com.zy.blogs.blogssample.rxjava.SubscriberCallBack;

/**
 * Created by zy on 2016/9/17.
 */
public class HomePresenter extends BasePresenter<HomeVew> {

    public HomePresenter(HomeVew mainFragment) {
        attachView(mainFragment);
    }

    public void homeLoadData(String app, String page, String showall) {
        mvpView.showLoading();
        addSubscription(apiStores.homeLoad(app, page, showall),
                new SubscriberCallBack<>(new ApiCallback<UserModel>() {
                    @Override
                    public void onSuccess(UserModel data) {
                        mvpView.loadData(data);
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
