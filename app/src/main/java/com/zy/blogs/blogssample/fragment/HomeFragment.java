package com.zy.blogs.blogssample.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.model.UserData;
import com.zy.blogs.blogssample.mvp.MvpFragment;
import com.zy.blogs.blogssample.mvp.main.HomePresenter;
import com.zy.blogs.blogssample.mvp.main.HomeVew;

import butterknife.Bind;

/**
 * Created by zy on 2016/9/17.
 */
public class HomeFragment extends MvpFragment<HomePresenter> implements HomeVew {

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setUpContentView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(false);
    }

    @Override
    protected void setUpData() {
        mvpPresenter.homeLoadData("10", "1", "showall");
//        System.out.println("updata");
    }


    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void loadData(UserData userData) {

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
