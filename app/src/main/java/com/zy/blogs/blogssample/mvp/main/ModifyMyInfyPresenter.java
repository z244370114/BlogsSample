package com.zy.blogs.blogssample.mvp.main;

import com.zy.blogs.blogssample.model.ErrModel;
import com.zy.blogs.blogssample.model.UpdateModel;
import com.zy.blogs.blogssample.mvp.BasePresenter;
import com.zy.blogs.blogssample.rxjava.ApiCallback;
import com.zy.blogs.blogssample.rxjava.SubscriberCallBack;

import java.util.List;

import okhttp3.RequestBody;

/**
 * <p/>
 * 作者：zhouyuan on  2016/9/27 17:34
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class ModifyMyInfyPresenter extends BasePresenter<ModifyMyInfyView> {

    public ModifyMyInfyPresenter(ModifyMyInfyView ModifyMyInfyActivity) {
        attachView(ModifyMyInfyActivity);
    }

    public void updataImage(RequestBody file) {
        mvpView.showLoading();
        addSubscription(apiStores.updateImage(file),
                new SubscriberCallBack<>(new ApiCallback<UpdateModel>() {
                    @Override
                    public void onSuccess(UpdateModel model) {
                        System.out.println("model = " + model);
                        mvpView.updateImage(model.getUrl());
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


    public void modifyUserData(String uid, String email, String avatar_url) {
        mvpView.showLoading();
        addSubscription(apiStores.modifyUserData(uid, email, avatar_url),
                new SubscriberCallBack(new ApiCallback<List<Integer>>() {


                    @Override
                    public void onSuccess(List<Integer> data) {
                        mvpView.modifySuccess(data);
                    }

                    @Override
                    public void onFailure(int code, String msg, ErrModel errData) {

                    }

                    @Override
                    public void onFailure(int code, String msg) {

                    }

                    @Override
                    public void onCompleted() {

                    }
                }));


    }

}
