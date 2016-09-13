package com.zy.blogs.blogssample.model;

import java.io.Serializable;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/13 11:27
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class UpdateModel implements Serializable {

    private static final long serialVersionUID = -5111218347139238028L;
    /**
     * state : SUCCESS
     * url : /uploads/image/20160913/1473732252436022.png
     * title : 1473732252436022.png
     * original : 1908.png
     * type : .png
     * size : 59407
     */

    private String state;
    private String url;
    private String title;
    private String original;
    private String type;
    private int size;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
