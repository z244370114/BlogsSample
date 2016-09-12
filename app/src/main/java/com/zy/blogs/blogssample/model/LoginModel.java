package com.zy.blogs.blogssample.model;

import java.io.Serializable;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 15:09
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class LoginModel implements Serializable {

    private static final long serialVersionUID = -8101514707195894853L;

    private String username;
    private String password;
    private String avatar_url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
