package com.zy.blogs.blogssample.activity;

import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.widget.ImageView;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.BaseActivity;

/**
 * <p/>
 * 作者：zhouyuan on  2016/11/8 11:55
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class RoundButtonActivity extends BaseActivity {

    private ImageView img;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.round_button, -1, -1, MODE_NONE);
        img = (ImageView) findViewById(R.id.img);
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat =
                AnimatedVectorDrawableCompat.create(RoundButtonActivity.this, R.drawable.anim_sv);
        img.setImageDrawable(animatedVectorDrawableCompat);
        animatedVectorDrawableCompat.start();
    }

    @Override
    protected void setUpData() {

    }
}
