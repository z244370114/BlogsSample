package com.zy.blogs.blogssample.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.activity.WebViewActivity;
import com.zy.blogs.blogssample.adapter.BlogsAdapter;
import com.zy.blogs.blogssample.model.GankModel;
import com.zy.blogs.blogssample.mvp.MvpFragment;
import com.zy.blogs.blogssample.mvp.main.BlogsPresenter;
import com.zy.blogs.blogssample.mvp.main.BlogsView;

import butterknife.Bind;

/**
 * Created by zy on 2016/9/17.
 */
public class BlogsFragment extends MvpFragment<BlogsPresenter> implements BlogsView {

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    BlogsAdapter mAdapter;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_blogs;
    }

    @Override
    protected void setUpContentView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(false);
        mAdapter = new BlogsAdapter(getActivity(), null, false);
        mAdapter.setOnItemClickListener((viewHolder, userMdel, i) -> {
            GoActivity(WebViewActivity.class, userMdel.getUrl());
//            showToast(userModel.getWho() + "\n" + i);
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void setUpData() {
        mvpPresenter.loadData(20, 2);
    }

    @Override
    protected BlogsPresenter createPresenter() {
        return new BlogsPresenter(this);
    }

    @Override
    public void loadData(GankModel gankModel) {
        mAdapter.setNewData(gankModel.getResults());
    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
