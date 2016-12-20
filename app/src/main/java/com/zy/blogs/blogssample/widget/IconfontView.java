package com.zy.blogs.blogssample.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * <p/>
 * 作者：zhouyuan on  2016/12/14 11:50
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class IconfontView extends TextView {

    public IconfontView(Context context) {
        super(context);
        initFont();
    }

    public IconfontView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFont();
    }

    public IconfontView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFont();
    }

    private void initFont() {
        final Typeface iconfont = Typeface.createFromAsset(getContext().getApplicationContext().getAssets(), "fonts/iconfont.ttf");
        setTypeface(iconfont);
    }
}
