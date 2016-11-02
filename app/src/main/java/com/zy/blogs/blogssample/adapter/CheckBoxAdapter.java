package com.zy.blogs.blogssample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.zy.blogs.blogssample.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p/>
 * 作者：zhouyuan on  2016/11/2 10:52
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public class CheckBoxAdapter extends RecyclerView.Adapter<CheckBoxAdapter.ViewHolder> {

    private List<String> list;
    private Context context;
    //是否显示单选框,默认false
    private boolean isshowBox = false;
    // 存储勾选框状态的map集合
    private Map<Integer, Boolean> map = new HashMap<>();

    public CheckBoxAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        initMap();
    }

    private void initMap() {
        for (int i = 0; i < list.size(); i++) {
            map.put(i, false);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_checkbox, parent, false);
//        //为Item设置点击事件
//        root.setOnClickListener(this);
//        root.setOnLongClickListener(this);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(list.get(position));
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> map.put(position, isChecked));
        if (map.get(position) == null) {
            map.put(position, false);
        }
        holder.checkBox.setChecked(map.get(position));

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    //点击item选中CheckBox
    public void setSelectItem(int position) {
        //对当前状态取反
        if (map.get(position)) {
            map.put(position, false);
        } else {
            map.put(position, true);
        }
        notifyItemChanged(position);
    }

    //返回集合给MainActivity
    public Map<Integer, Boolean> getMap() {
        return map;
    }

    //视图管理
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private CheckBox checkBox;
        private View root;

        public ViewHolder(View root) {
            super(root);
            this.root = root;
            title = (TextView) root.findViewById(R.id.tv_title);
            checkBox = (CheckBox) root.findViewById(R.id.cb);
        }
    }

}
