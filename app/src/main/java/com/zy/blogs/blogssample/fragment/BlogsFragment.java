package com.zy.blogs.blogssample.fragment;

import android.support.v7.widget.RecyclerView;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.BaseFragment;

import butterknife.Bind;

/**
 * Created by zy on 2016/9/17.
 */
public class BlogsFragment extends BaseFragment {

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_blogs;
    }

    @Override
    protected void setUpContentView() {

    }

    @Override
    protected void setUpData() {

    }
}
