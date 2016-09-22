package com.zy.blogs.blogssample.base;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;

/**
 * Created by zhulei on 16/5/27.
 */
public abstract class AppActivity extends BaseActivity {

    protected abstract int getContentViewId();

    protected abstract Fragment getFirstFragment();

    protected abstract int getFragmentContainerId();


    @Override
    protected void setUpContentView() {
        //写死竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //处理Intent(主要用来获取其中携带的参数)
        if (getIntent() != null) {
            handleIntent(getIntent());
        }
        setContentView(getContentViewId());
        //添加栈底的第一个fragment
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            if (getFirstFragment() != null) {
                addFragment(getFirstFragment());
            } else {
                throw new NullPointerException("getFirstFragment() cannot be null");
            }
        }
    }


    protected void handleIntent(Intent intent) {

    };

    @Override
    protected void setUpData() {

    }


    public void addFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContainerId(), fragment)
                    .addToBackStack(((Object) fragment).getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
            return true;
        }
        return super.onSupportNavigateUp();
    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Intent intent = super.getSupportParentActivityIntent();
        if (intent == null) {
            finish();
        }
        return intent;
    }

    //回退键处理
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
