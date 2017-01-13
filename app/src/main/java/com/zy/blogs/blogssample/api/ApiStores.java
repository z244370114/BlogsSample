package com.zy.blogs.blogssample.api;

import com.zy.blogs.blogssample.model.GWDatas;
import com.zy.blogs.blogssample.model.GankModel;
import com.zy.blogs.blogssample.model.LoginModel;
import com.zy.blogs.blogssample.model.UpdateModel;
import com.zy.blogs.blogssample.model.UserModel;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/12 15:01
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public interface ApiStores {

    //    String BASE_URL = "http://www.myblog.com/api/";
    String BASE_URL1 = "http://gank.io/api/";//乾貨集中營API
    String BASE_URL = "https://jia.deyi.com/";//得意家数据

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
     * 修改密码
     *
     * @param uid
     * @param password
     * @param npassword
     * @return
     */
    @FormUrlEncoded
    @POST("user/update-user-password")
    Observable<List<Integer>> modifyData(@Field("uid") String uid, @Field("o-password") String password, @Field("n-password") String npassword);

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @Multipart
    @POST("upload-file/app-upload-file?action=uploadimage&encode=utf-8")
    Observable<UpdateModel> updateImage(@Part("upfile\"; filename=\"1111.jpg\"") RequestBody file);

    /**
     * 显示用户数据
     *
     * @param app
     * @param page
     * @param showall
     * @return
     */
    @FormUrlEncoded
    @POST("user/list")
    Observable<UserModel> homeLoad(@Field("rpp") String app, @Field("page") String page,
                                   @Field("showall") String showall);

    /**
     * 更改用户资料
     *
     * @param uid
     * @param email
     * @param avatar_url
     * @return
     */
    @FormUrlEncoded
    @POST("user/update-user-data")
    Observable<List<Integer>> modifyUserData(@Field("uid") String uid, @Field("email") String email,
                                             @Field("avatar_url") String avatar_url);

    /**
     * 读取某一条用户数据
     *
     * @param uid
     * @return
     */
    @FormUrlEncoded
    @POST("user/read")
    Observable<UserModel> readUserData(@Field("uid") String uid);

    /**
     * 干货集中营
     *
     * @param number
     * @param page
     * @return
     */
    @GET("data/Android/{number}/{page}")
    Observable<GankModel> loadAndroidData(@Path("number") int number, @Path("page") int page);

    @FormUrlEncoded
    @POST("apiv1/benefit/list")
    Call<GWDatas> loadWelfare(
                              @Field("roleid") String roleid, @Field("uid") String uid);

}
