package com.zy.blogs.blogssample.adapter;

import android.content.Context;

import com.othershe.baseadapter.ViewHolder;
import com.othershe.baseadapter.base.CommonBaseAdapter;
import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.model.UserModel;

import java.util.List;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/18 11:58
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class HomeAdapter extends CommonBaseAdapter<UserModel> {

    public HomeAdapter(Context context, List<UserModel> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder viewHolder, UserModel userModel) {
        viewHolder.setText(R.id.tv_username, userModel.getUsername());
        viewHolder.setText(R.id.tv_createtime, userModel.getCreate_time());
//        Glide.with(mContext)
//                .load(userModel.getAvatar_url())
//                .asBitmap()
//                .into()
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_home;
    }
}
