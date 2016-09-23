package com.zy.blogs.blogssample.activity;


import android.support.v4.app.Fragment;
import android.view.KeyEvent;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.BaseActivity;
import com.zy.blogs.blogssample.fragment.LoginFragment;
import com.zy.blogs.blogssample.fragment.RegisterFragment;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 13:12
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class LoginActivity extends BaseActivity {
    private String type;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_login, R.string.login, -1, 0);
    }

    @Override
    protected void setUpData() {
        type = getIntent().getStringExtra(TYPE);
        if (type.equals("login")) {
            addFragment(new LoginFragment(), R.string.login);
        } else {
            addFragment(RegisterFragment.newInstance(type), R.string.modified_password);
        }
    }


    public void addFragment(Fragment fragment, int str) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.login_layout, fragment)
                .addToBackStack(((Object) fragment).getClass().getSimpleName())
                .commitAllowingStateLoss();
        toolbar_title.setText(str);
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
                return true;
            } else {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
