package com.zy.blogs.blogssample.api;

import com.zy.blogs.blogssample.model.LoginModel;
import com.zy.blogs.blogssample.model.UpdateModel;

import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/12 15:01
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public interface ApiStores {

    String BASE_URL = "http://www.myblog.com/api/";

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

    /**
     * 上传图片
     * @param file
     * @return
     */
    @Multipart
    @POST("upload-file/app-upload-file?action=uploadimage&encode=utf-8")
    Observable<UpdateModel> updateImage(@Part("upfile\"; filename=\"1111.jpg\"") RequestBody file);
}
