package com.zy.blogs.blogssample.base;

import android.os.Bundle;
import android.view.View;

/**
 * Created by zhulei on 16/5/27.
 */
public abstract class AppFragment extends BaseFragment {

    protected abstract int getLayoutId();

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected void releaseView() {

    }

    ;

    protected AppActivity getHoldingActivity() {
        if (getActivity() instanceof AppActivity) {
            return (AppActivity) getActivity();
        } else {
            throw new ClassCastException("activity must extends AppActivity");
        }
    }

    protected void addFragment(BaseFragment fragment) {
        getHoldingActivity().addFragment(fragment);
    }

    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }

//    @Override
//    protected void initAppView(View mRootView, Bundle savedInstanceState) {
//        initView(mRootView, savedInstanceState);
//    }

    @Override
    protected int setLayoutResouceId() {
        return getLayoutId();
    }

    @Override
    protected void setUpContentView() {

    }

    @Override
    protected void setUpData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        releaseView();
    }

}
