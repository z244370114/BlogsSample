package com.zy.blogs.blogssample.model;

import java.io.Serializable;

/**
 * <p/>
 * 作者：zhouyuan on  2016/9/21 17:10
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class BaseModel<T> implements Serializable {

    private static final long serialVersionUID = -7263977731102811128L;
    private String id;
    private String message;
    private String url;


    public T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
