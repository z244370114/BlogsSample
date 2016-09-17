package com.zy.blogs.blogssample.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zy on 2016/9/17.
 */
public class UserData implements Serializable {

    private static final long serialVersionUID = 3879523021748979109L;


    /**
     * total_nums : 10
     * data : [{"uid":"10","username":"hdb2016","email":"","is_deleted":"0","avatar_url":"","create_time":"2016-09-13 09:45:52"},{"uid":"9","username":"hdb哈哈哈","email":"","is_deleted":"0","avatar_url":"","create_time":"2016-09-12 16:45:44"},{"uid":"8","username":"hdbwe","email":"","is_deleted":"1","avatar_url":"","create_time":"2016-09-10 17:24:28"}]
     */

    private String total_nums;
    /**
     * uid : 10
     * username : hdb2016
     * email :
     * is_deleted : 0
     * avatar_url :
     * create_time : 2016-09-13 09:45:52
     */

    private List<UserData> data;
    private String uid;
    private String username;
    private String email;
    private String is_deleted;
    private String avatar_url;
    private String create_time;


    public String getTotal_nums() {
        return total_nums;
    }

    public void setTotal_nums(String total_nums) {
        this.total_nums = total_nums;
    }

    public List<UserData> getData() {
        return data;
    }

    public void setData(List<UserData> data) {
        this.data = data;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
