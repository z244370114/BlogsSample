package com.zy.blogs.blogssample.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;

import com.zy.blogs.blogssample.ActivityCollector;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/14 15:32
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class BaseFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        System.out.println(getClass().getSimpleName());
        ActivityCollector.getInstance().addActivity(this);
    }

    protected void closeImm() {
        if (getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(
                            getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
    }

    @Override
    public void finish() {
        // TODO Auto-generated method stub
        super.finish();
    }
}
