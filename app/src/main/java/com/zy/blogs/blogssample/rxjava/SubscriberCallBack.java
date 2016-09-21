package com.zy.blogs.blogssample.rxjava;

import android.net.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.zy.blogs.blogssample.model.ErrModel;

import org.json.JSONException;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Administrator
 * on 2016/5/18.
 */
public class SubscriberCallBack<T> extends Subscriber<T> {

    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;


    private ApiCallback<T> apiCallback;
    private ErrModel errData;

    public SubscriberCallBack(ApiCallback<T> apiCallback) {
        this.apiCallback = apiCallback;
    }

    @Override
    public void onCompleted() {
        apiCallback.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            errData = handle(httpException);
            int code = httpException.code();
            String msg = httpException.getMessage();
            switch (code) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    msg = "网络错误";  //均视为网络错误
                    break;
            }

            apiCallback.onFailure(code, msg, errData);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            apiCallback.onFailure(0, "JSON解析错误", errData);
        }
        apiCallback.onCompleted();
    }

    @Override
    public void onNext(T t) {
        apiCallback.onSuccess(t);
    }


    public static ErrModel handle(HttpException throwable) {
        try {
            return new Gson().fromJson(throwable.response().errorBody().string(),
                    ErrModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
