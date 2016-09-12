package com.zy.blogs.blogssample.api;

import com.zy.blogs.blogssample.model.LoginModel;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 15:21
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public interface LoginApi {

    /**
     * 登录接口
     *
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("user-login/login")
    Observable<LoginModel> loginData(@Field("username") String username, @Field("password") String password);

    /**
     * 注册接口
     *
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("user-register/register")
    Observable<LoginModel> registerData(@Field("username") String username, @Field("password") String password);
}
