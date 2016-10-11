package com.zy.blogs.blogssample.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.othershe.baseadapter.ViewHolder;
import com.othershe.baseadapter.base.CommonBaseAdapter;
import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.model.GankModel;

import java.util.List;

/**
 * <p/>
 * 作者：zhouyuan on  2016/10/11 15:33
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public class BlogsAdapter extends CommonBaseAdapter<GankModel> {


    private Context context;

    public BlogsAdapter(Context context, List<GankModel> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder viewHolder, GankModel gankModel) {
        viewHolder.setText(R.id.tv_title, gankModel.getWho());
        if (gankModel.getImages() != null) {
            String images = gankModel.getImages().get(0);
            Glide.with(context)
                    .load(images)
                    .into((ImageView) viewHolder.getView(R.id.iv_image));
        }
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_blogs;
    }
}
