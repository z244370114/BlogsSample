package com.zy.blogs.blogssample.activity;

import android.os.Environment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.adapter.CheckBoxAdapter;
import com.zy.blogs.blogssample.base.BaseActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

/**
 * <p/>
 * 作者：zhouyuan on  2016/11/2 10:31
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class CheckBoxRecycleView extends BaseActivity {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    CheckBoxAdapter adapter;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_checkbox);
    }

    @Override
    protected void setUpData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<String> list = new ArrayList<>();
        File directory = Environment.getExternalStorageDirectory();
        File[] files = directory.listFiles();
        list = new ArrayList<>();
        for (File file : files) {
            list.add(file.getName());
        }
        adapter = new CheckBoxAdapter(this, list);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(() -> swipeRefreshLayout.setRefreshing(false));

    }

    private void allSelect() {
        Map<Integer, Boolean> map = adapter.getMap();
        for (int i = 0; i < map.size(); i++) {
            map.put(i, true);
            adapter.notifyDataSetChanged();
        }
    }

    private void clearSelect() {
        Map<Integer, Boolean> map = adapter.getMap();
        for (int i = 0; i < map.size(); i++) {
            map.put(i, false);
            adapter.notifyDataSetChanged();
        }
    }

}
