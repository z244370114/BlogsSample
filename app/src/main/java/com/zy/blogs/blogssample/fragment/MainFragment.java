package com.zy.blogs.blogssample.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.activity.MainActivity1;
import com.zy.blogs.blogssample.base.BaseFragment;

import butterknife.Bind;

/**
 * Created by zy on 2016/9/18.
 */
public class MainFragment extends BaseFragment {

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpContentView() {
        mToolbar.setNavigationIcon(R.drawable.icon_menu);
        mToolbar.setTitle("首页");
        TabPagerAdapter adapter = new TabPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                mToolbar.setTitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mToolbar.setNavigationOnClickListener(v -> ((MainActivity1) getActivity()).openDrawerLayou());

    }

    @Override
    protected void setUpData() {

    }

    class TabPagerAdapter extends FragmentStatePagerAdapter {

        private final String[] TITLES = {getString(R.string.home),
                getString(R.string.app_name)};

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new BlogsFragment();
                default:
                    return new HomeFragment();
            }
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return TITLES[position];
        }
    }
}
