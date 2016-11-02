package com.zy.blogs.blogssample.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.BaseActivity;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/14 13:36
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class StartActivity extends BaseActivity {


    @Override
    protected void setUpContentView() {
        View mDecorView = getWindow().getDecorView();
        mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_start, -1, MODE_NONE);
    }


    @Override
    protected void setUpData() {
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(StartActivity.this, MainActivity1.class));
            finish();
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeMessages(0);
    }

}
