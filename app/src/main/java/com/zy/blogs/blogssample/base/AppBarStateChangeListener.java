package com.zy.blogs.blogssample.base;

import android.support.design.widget.AppBarLayout;

/**
 * <p/>
 * 作者：zhouyuan on  2016/9/20 14:15
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
    /**
     * 枚举定义出CollapsingToolbarLayout展开、折叠、中间，这三种状态。
     */
    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    /**
     * 滑动偏移量
     */
    public int verticalOffset = 0;

    private State mCurrentState = State.IDLE;

    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED);
            }
            mCurrentState = State.EXPANDED;
            verticalOffset = i;
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED);
            }
            mCurrentState = State.COLLAPSED;
            verticalOffset = i;
        } else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE);
            }
            mCurrentState = State.IDLE;
            verticalOffset = i;
        }
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
}
