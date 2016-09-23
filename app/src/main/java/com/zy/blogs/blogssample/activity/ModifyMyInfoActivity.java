package com.zy.blogs.blogssample.activity;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.BaseActivity;

/**
 * <p/>
 * 作者：zhouyuan on  2016/9/23 17:33
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class ModifyMyInfoActivity extends BaseActivity {


    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_modify_my_info, R.string.redact, -1, MODE_BACK);
        toolbar.setBackgroundColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.icon_back_black);
        toolbar_title.setTextColor(getResources().getColor(R.color.primary_text));
    }

    @Override
    protected void setUpData() {

    }
}
