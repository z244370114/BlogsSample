package com.zy.blogs.blogssample.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.BaseActivity;
import com.zy.blogs.blogssample.fragment.MainFragment;

import butterknife.Bind;

/**
 * Created by zy on 2016/9/18.
 */
public class MainActivity1 extends BaseActivity {


    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.nv_menu)
    NavigationView mNavigationView;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_main1, R.string.home, 2);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new MainFragment(), "Main")
                .commit();
    }

    @Override
    protected void setUpData() {

    }
}
