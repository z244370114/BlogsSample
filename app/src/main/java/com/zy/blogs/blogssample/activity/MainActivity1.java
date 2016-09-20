package com.zy.blogs.blogssample.activity;

import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
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
    @Bind(R.id.nav_menu)
    NavigationView mNavigationView;
    private TextView tvUsername;
    private RoundedImageView ivHeadPortrait;


    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_main1, R.string.home, 2);
    }

    @Override
    protected void setUpData() {
//        View rlHeader = mNavigationView.inflateHeaderView(R.layout.header_just_username);
        View rlHeader = mNavigationView.getHeaderView(0);
        tvUsername = (TextView) rlHeader.findViewById(R.id.tv_username);
        ivHeadPortrait = (RoundedImageView) rlHeader.findViewById(R.id.iv_head_portrait);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new MainFragment(), "Main")
                .commit();

        rlHeader.setOnClickListener(v -> {

            GoActivity(LoginActivity.class);

        });

        mNavigationView.setNavigationItemSelectedListener(menuItem -> {
            @IdRes
            int menuId = menuItem.getItemId();
            switch (menuId) {
                case R.id.nav_my_info:
                    GoActivity(MyInfoActivity.class);
                    break;
                case R.id.nav_modified_password:

                    break;
                case R.id.nav_action_settings:

                    break;
                case R.id.nav_about:

                    break;
            }
            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();
            return true;
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (!mDrawerLayout.isShown()) {
            mDrawerLayout.closeDrawers();
        }
    }


    /**
     * 方便MainFragment 按钮点击
     */
    public void openDrawerLayou() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

}
