package com.zy.blogs.blogssample.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.api.ApiManage;
import com.zy.blogs.blogssample.api.ApiStores;
import com.zy.blogs.blogssample.base.AppBarStateChangeListener;
import com.zy.blogs.blogssample.base.BaseActivity;
import com.zy.blogs.blogssample.model.UserModel;

import java.lang.ref.WeakReference;

import butterknife.Bind;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.zy.blogs.blogssample.R.id.collapsing_toolbar_layout;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/20 10:49
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class MyInfoActivity extends BaseActivity {

    @Bind(R.id.image)
    ImageView image;
    @Bind(collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.btn_redact)
    Button btnRedact;
    @Bind(R.id.tv_username)
    TextView tvUsername;
    @Bind(R.id.tv_email)
    TextView tvEmail;
    @Bind(R.id.iv_avatar)
    RoundedImageView ivAvatar;
    @Bind(R.id.tv_detail)
    TextView tvDetail;
    @Bind(R.id.rl_layout)
    RelativeLayout rlLayout;
    private WeakReference weakReference;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_my_info, -1, R.menu.menu_myinfo, MODE_BACK);
         weakReference = new WeakReference(MyInfoActivity.class);
    }

    @Override
    protected void setUpData() {
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED) {//展开状态
                    collapsingToolbarLayout.setTitle("");
                    System.out.println("EXPANDED = " + verticalOffset);
                } else if (state == State.COLLAPSED) { //折叠状态
                    collapsingToolbarLayout.setTitle(tvUsername.getText().toString().trim());
                    System.out.println("COLLAPSED = " + verticalOffset);
                } else {//中间状态
                    System.out.println("IDLE = " + verticalOffset);
                    collapsingToolbarLayout.setTitle("");
//                    if(Math.abs(verticalOffset) > )
                }
            }
        });

        btnRedact.setOnClickListener(v -> GoActivity(ModifyMyInfoActivity.class));

        ApiStores apiStores = ApiManage.retrofit().create(ApiStores.class);
        apiStores.readUserData("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserModel userModel) {
                        Glide.with(MyInfoActivity.this)
                                .load(userModel.getAvatar_url())
                                .asBitmap()
                                .into(ivAvatar);
                        Glide.with(MyInfoActivity.this)
                                .load(userModel.getAvatar_url())
                                .asBitmap()
                                .into(image);
                        Glide.with(MyInfoActivity.this)
                                .load(userModel.getAvatar_url())
                                .asBitmap()
                                .into(new SimpleTarget<Bitmap>() {
                                    @Override
                                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                        Drawable bd = new BitmapDrawable(resource);
                                        collapsingToolbarLayout.setContentScrim(bd);
                                    }
                                });
                        tvUsername.setText(userModel.getUsername());
                        tvEmail.setText(userModel.getEmail());
                        tvDetail.setText(userModel.getCreate_time());
                    }
                });

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        GoActivity(ModifyMyInfoActivity.class);
        weakReference.get();
        return super.onMenuItemClick(item);
    }

}
