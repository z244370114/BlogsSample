package com.zy.blogs.blogssample.activity;


import android.support.v4.app.Fragment;
import android.view.KeyEvent;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.BaseActivity;
import com.zy.blogs.blogssample.fragment.LoginFragment;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 13:12
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class LoginActivity extends BaseActivity {


    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_login, R.string.login, R.menu.menu_main, 0);
    }

    @Override
    protected void setUpData() {
        addFragment(new LoginFragment());
    }


    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.login_layout, fragment)
                .addToBackStack(((Object) fragment).getClass().getSimpleName())
                .commitAllowingStateLoss();
        System.out.println("getSupportFragmentManager().getBackStackEntryCount() = "
                + getSupportFragmentManager().getBackStackEntryCount());
        toolbar_title.setText(R.string.register);
    }

    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
            toolbar_title.setText(R.string.login);
        } else {
            finish();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                getSupportFragmentManager().popBackStack();
                toolbar_title.setText(R.string.login);
                System.out.println("getSupportFragmentManager().getBackStackEntryCount() = "
                        + getSupportFragmentManager().getBackStackEntryCount());
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
