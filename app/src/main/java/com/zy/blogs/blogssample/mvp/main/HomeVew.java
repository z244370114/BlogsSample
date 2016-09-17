package com.zy.blogs.blogssample.mvp.main;

import com.zy.blogs.blogssample.model.UserData;
import com.zy.blogs.blogssample.mvp.BaseView;

/**
 * Created by zy on 2016/9/17.
 */
public interface HomeVew extends BaseView {

    void loadData(UserData userData);

}
