package com.zy.blogs.blogssample.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.BaseActivity;
import com.zy.blogs.blogssample.fragment.BlogsFragment;
import com.zy.blogs.blogssample.fragment.HomeFragment;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

//    @Bind(R.id.drawer_layout)
//    DrawerLayout mDrawerLayout;
//    @Bind(R.id.nv_menu)
//    NavigationView mNavigationView;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_main, R.string.home, 3);
    }

    @Override
    protected void setUpData() {
        toolbar.setNavigationIcon(R.drawable.icon_menu);
        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        toolbar.setNavigationOnClickListener(v -> {
            showToast("显示侧滑菜单");
//            mDrawerLayout.openDrawer(GravityCompat.START);
        });

//        mNavigationView.setNavigationItemSelectedListener(item -> {
//            item.setChecked(true);
//            mDrawerLayout.closeDrawers();
//            return true;
//        });
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
