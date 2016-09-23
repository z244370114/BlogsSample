package com.zy.blogs.blogssample.mvp.main;

import com.zy.blogs.blogssample.model.LoginModel;
import com.zy.blogs.blogssample.mvp.BaseView;

import java.util.List;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 15:06
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public interface LoginView extends BaseView {

    void loginData(LoginModel data);

    void registerData(LoginModel data);

    void modifyData(List<Integer> data);
}
