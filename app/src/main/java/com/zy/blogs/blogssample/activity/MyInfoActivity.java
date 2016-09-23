package com.zy.blogs.blogssample.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.ImageView;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.AppBarStateChangeListener;
import com.zy.blogs.blogssample.base.BaseActivity;

import butterknife.Bind;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/20 10:49
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class MyInfoActivity extends BaseActivity {

    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_my_info, -1, R.menu.menu_myinfo, MODE_BACK);
    }

    @Override
    protected void setUpData() {
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED) {//展开状态
                    toolbar_title.setText("");
                    System.out.println("EXPANDED = " + verticalOffset);
                } else if (state == State.COLLAPSED) { //折叠状态
                    toolbar_title.setText(R.string.my_info);
                    System.out.println("COLLAPSED = " + verticalOffset);
                } else {//中间状态
                    toolbar_title.setText("");
                    System.out.println("IDLE = " + verticalOffset);
//                    if(Math.abs(verticalOffset) > )
                }
            }
        });

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        GoActivity(ModifyMyInfoActivity.class);
        return super.onMenuItemClick(item);
    }
}
