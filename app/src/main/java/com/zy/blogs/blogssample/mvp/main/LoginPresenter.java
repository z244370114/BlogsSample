package com.zy.blogs.blogssample.mvp.main;

import com.zy.blogs.blogssample.model.ErrModel;
import com.zy.blogs.blogssample.model.LoginModel;
import com.zy.blogs.blogssample.model.UpdateModel;
import com.zy.blogs.blogssample.mvp.BasePresenter;
import com.zy.blogs.blogssample.rxjava.ApiCallback;
import com.zy.blogs.blogssample.rxjava.SubscriberCallBack;

import java.util.List;

import okhttp3.RequestBody;

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
        addSubscription(apiStores.loginData(username, password),
                new SubscriberCallBack<>(new ApiCallback<LoginModel>() {
                    @Override
                    public void onSuccess(LoginModel model) {
                        mvpView.loginData(model);
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

    public void registerData(String username, String password) {
        mvpView.showLoading();
        addSubscription(apiStores.registerData(username, password),
                new SubscriberCallBack<>(new ApiCallback<LoginModel>() {
                    @Override
                    public void onSuccess(LoginModel model) {
                        mvpView.registerData(model);
                    }

                    @Override
                    public void onFailure(int code, String msg, ErrModel errData) {
                        String massage = errData.getError().getMessage();
                        mvpView.getDataFail(massage);
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

    public void modifyData(String uid, String password, String npassword) {
        mvpView.showLoading();
        addSubscription(apiStores.modifyData(uid, password, npassword),
                new SubscriberCallBack<>(new ApiCallback<List<Integer>>() {

                    @Override
                    public void onSuccess(List<Integer> data) {
                        System.out.println("data = " + data);
                        mvpView.modifyData(data);
                    }

                    @Override
                    public void onFailure(int code, String msg, ErrModel errData) {
                        String massage = errData.getError().getMessage();
                        mvpView.getDataFail(massage);
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

    public void updataImage(RequestBody file) {
        mvpView.showLoading();
        addSubscription(apiStores.updateImage(file),
                new SubscriberCallBack<>(new ApiCallback<UpdateModel>() {
                    @Override
                    public void onSuccess(UpdateModel model) {
                        System.out.println("model = " + model);
                    }

                    @Override
                    public void onFailure(int code, String msg, ErrModel errData) {
                        mvpView.getDataFail(msg);
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
