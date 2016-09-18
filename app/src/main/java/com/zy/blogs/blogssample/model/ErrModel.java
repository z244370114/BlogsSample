package com.zy.blogs.blogssample.model;

import java.io.Serializable;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/13 11:52
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class ErrModel implements Serializable {
    private static final long serialVersionUID = -8793342971156681347L;


    /**
     * id : username_error
     * message : 该用户名已经存在,请更换其他的用户名
     * url :
     */
    private ErrorEntity error;

    public ErrorEntity getError() {
        return error;
    }

    public void setError(ErrorEntity error) {
        this.error = error;
    }

    public static class ErrorEntity {
        private String id;
        private String message;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
