package com.zy.blogs.blogssample.mvp.main;

import com.zy.blogs.blogssample.mvp.BaseView;

import java.util.List;

/**
 * <p/>
 * 作者：zhouyuan on  2016/9/27 17:34
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public interface ModifyMyInfyView extends BaseView {

    void updateImage(String url);

    void modifySuccess(List<Integer> data);
}
