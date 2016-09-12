package com.zy.blogs.blogssample.mvp.main;

import com.zy.blogs.blogssample.api.ApiManage;
import com.zy.blogs.blogssample.model.LoginModel;
import com.zy.blogs.blogssample.mvp.BasePresenter;
import com.zy.blogs.blogssample.rxjava.ApiCallback;
import com.zy.blogs.blogssample.rxjava.SubscriberCallBack;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 15:01
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView loginActivity) {
        attachView(loginActivity);
    }

    public void loginData(String username, String password) {
        mvpView.showLoading();
        addSubscription(ApiManage.getInstence().getLoginApiService().loginData(username, password),
                new SubscriberCallBack<>(new ApiCallback<LoginModel>() {
                    @Override
                    public void onSuccess(LoginModel model) {
                        mvpView.loginData(model);
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

    public void registerData(String username, String password) {
        mvpView.showLoading();
        addSubscription(ApiManage.getInstence().getLoginApiService().registerData(username, password),
                new SubscriberCallBack<>(new ApiCallback<LoginModel>() {
                    @Override
                    public void onSuccess(LoginModel model) {
                        mvpView.registerData(model);
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
