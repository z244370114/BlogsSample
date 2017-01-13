package com.zy.blogs.blogssample.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.api.ApiManage;
import com.zy.blogs.blogssample.api.ApiStores;
import com.zy.blogs.blogssample.base.BaseActivity;
import com.zy.blogs.blogssample.model.GWDatas;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/14 13:36
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class StartActivity extends BaseActivity {


    @Override
    protected void setUpContentView() {
        View mDecorView = getWindow().getDecorView();
        mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_start, -1, MODE_NONE);
    }


    @Override
    protected void setUpData() {
        handler.sendEmptyMessageDelayed(0, 1000);
        ApiStores service = ApiManage.retrofit1().create(ApiStores.class);
        Call<GWDatas> call = service.loadWelfare("", "");
        call.enqueue(new Callback<GWDatas>() {
            @Override
            public void onResponse(Call<GWDatas> call, Response<GWDatas> response) {
                System.out.println("call = [" + call + "], response = [" + response.body().getData().toString() + "]");
            }

            @Override
            public void onFailure(Call<GWDatas> call, Throwable t) {
                System.out.println("call = [" + call + "], t = [" + t + "]");
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(StartActivity.this, MainActivity1.class));
//            startActivity(new Intent(StartActivity.this, MyWebView.class));
            finish();
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeMessages(0);
    }

}
