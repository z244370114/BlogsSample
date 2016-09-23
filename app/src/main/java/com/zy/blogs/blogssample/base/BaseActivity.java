package com.zy.blogs.blogssample.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;
import com.zy.blogs.blogssample.ActivityCollector;
import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.util.FontHelper;

import butterknife.ButterKnife;


/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 13:12
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public abstract class BaseActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    public static final String TYPE = "type";
    protected Toolbar toolbar;
    protected TextView toolbar_title;
    public static final int MODE_BACK = 0;
    public static final int MODE_DRAWER = 1;
    public static final int MODE_NONE = 2;
    public static final int MODE_HOME = 3;
    private Toast mToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Activity", this.getClass().getSimpleName());
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setUpContentView();
        ButterKnife.bind(this);
        setUpData();
        FontHelper.injectFont(findViewById(android.R.id.content));
        ActivityCollector.getInstance().addActivity(this);
    }

    protected abstract void setUpContentView();

//    protected abstract void setUpView();

    protected abstract void setUpData();

    @Override
    public void setContentView(int layoutResID) {
        setContentView(layoutResID, -1, -1, MODE_BACK);
    }

    public void setContentView(int layoutResID, int titleResId) {
        setContentView(layoutResID, titleResId, -1, MODE_BACK);
    }

    public void setContentView(int layoutResID, int titleResId, int mode) {
        setContentView(layoutResID, titleResId, -1, mode);
    }

    /**
     * @param layoutResID 布局资源ID
     * @param titleResId  标题资源ID
     * @param menuId      右边布局菜单资源ID
     * @param mode        判断是否初始化 toolbar
     */
    public void setContentView(int layoutResID, int titleResId, int menuId, int mode) {
        super.setContentView(layoutResID);
        setUpToolbar(titleResId, menuId, mode);
    }

    private void setUpToolbar(int titleResId, int menuId, int mode) {
        if (mode != MODE_NONE) {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
//            toolbar.setTitle("");
            toolbar_title = (TextView) findViewById(R.id.tv_title);
            if (mode == MODE_BACK) {
                toolbar.setNavigationIcon(R.drawable.ic_toolbar_back);
                toolbar.setNavigationOnClickListener(view -> onNavigationBtnClicked());
            }
            setUpTitle(titleResId);
            setUpMenu(menuId);
        }
    }

    protected void setUpMenu(int menuId) {
        if (toolbar != null) {
            toolbar.getMenu().clear();
            if (menuId > 0) {
                toolbar.inflateMenu(menuId);
                toolbar.setOnMenuItemClickListener(this);
            }
        }
    }


    protected void setUpTitle(int titleResId) {
        if (titleResId > 0 && toolbar_title != null) {
            toolbar_title.setText(titleResId);
        }
    }

    protected void onNavigationBtnClicked() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    /**
     * 切换Activity
     *
     * @param c 需要切换到的Activity
     */
    public void GoActivity(Class<?> c) {
        Intent intent = new Intent(this, c);
        this.startActivity(intent);
    }

    /**
     * 切换Activity
     *
     * @param c    需要切换到的Activity
     * @param type 参数
     */
    public void GoActivity(Class<?> c, String type) {
        Intent intent = new Intent(this, c);
        intent.putExtra(TYPE, type);
        this.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        ActivityCollector.getInstance().removeActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageStart(this.getClass().getSimpleName());
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageEnd(this.getClass().getSimpleName());
        MobclickAgent.onResume(this);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }


    public void showToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }

}
