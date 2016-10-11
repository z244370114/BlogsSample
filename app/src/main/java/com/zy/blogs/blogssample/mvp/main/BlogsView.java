package com.zy.blogs.blogssample.mvp.main;

import com.zy.blogs.blogssample.model.GankModel;
import com.zy.blogs.blogssample.mvp.BaseView;

/**
 * <p/>
 * 作者：zhouyuan on  2016/10/11 15:14
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public interface BlogsView extends BaseView {

    void loadData(GankModel gankModel);
}
