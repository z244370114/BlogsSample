package com.zy.blogs.blogssample.activity;

import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.model.LoginModel;
import com.zy.blogs.blogssample.mvp.MvpActivity;
import com.zy.blogs.blogssample.mvp.main.LoginPresenter;
import com.zy.blogs.blogssample.mvp.main.LoginView;

/**
 * <p>
 * 作者：zhouyuan on  2016/9/10 13:12
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 */
public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginView, View.OnClickListener {

    private TextInputEditText mEt_username;
    private TextInputEditText mEt_userpassword;
    private Button mBtn_login;
    private Button mBtn_register;
    private ProgressBar mProgressBar;
    private ImageView iv_avatar;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_login, R.string.login, R.menu.menu_main, 0);
        bindViews();
    }


    private void bindViews() {
        mEt_username = (TextInputEditText) findViewById(R.id.et_username);
        mEt_userpassword = (TextInputEditText) findViewById(R.id.et_userpassword);
        mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        iv_avatar = (ImageView) findViewById(R.id.iv_avatar);
        mBtn_login = (Button) findViewById(R.id.btn_login);
        mBtn_register = (Button) findViewById(R.id.btn_register);
        mBtn_login.setOnClickListener(this);
        mBtn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mvpPresenter.loginData(mEt_username.getText().toString().trim(),
                        mEt_userpassword.getText().toString().trim());
                break;
            case R.id.btn_register:
                mvpPresenter.registerData(mEt_username.getText().toString().trim(),
                        mEt_userpassword.getText().toString().trim());
                break;
        }
    }

    @Override
    public void loginData(LoginModel data) {
        ShowToast("您登录的账号是：" + data.getUsername() + "\n" + "您登录的密码是：" + data.getPassword());
        Glide.with(this)
                .load(data.getAvatar_url())
                .asBitmap()
                .centerCrop()
                .into(iv_avatar);
    }

    @Override
    public void registerData(LoginModel data) {
        ShowToast("恭喜您注册成功！\n 您登录的账号是：" + data.getUsername() + "\n" + "您登录的密码是：" + data.getPassword());
    }

    @Override
    public void getDataFail(String msg) {
        ShowToast("失败：" + msg);

    }

    @Override
    public void showLoading() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }


}
