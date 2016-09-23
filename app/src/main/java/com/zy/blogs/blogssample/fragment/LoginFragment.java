package com.zy.blogs.blogssample.fragment;

import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.blankj.utilcode.utils.StringUtils;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.activity.LoginActivity;
import com.zy.blogs.blogssample.model.LoginModel;
import com.zy.blogs.blogssample.mvp.MvpFragment;
import com.zy.blogs.blogssample.mvp.main.LoginPresenter;
import com.zy.blogs.blogssample.mvp.main.LoginView;

import java.util.List;

import butterknife.Bind;

/**
 * <p/>
 * 作者：zhouyuan on  2016/9/22 10:26
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public class LoginFragment extends MvpFragment<LoginPresenter> implements LoginView {

    @Bind(R.id.iv_avatar)
    RoundedImageView ivAvatar;
    @Bind(R.id.et_username)
    TextInputEditText etUsername;
    @Bind(R.id.et_userpassword)
    TextInputEditText etUserpassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.mProgressBar)
    ProgressBar mProgressBar;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }


    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void setUpContentView() {

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etUserpassword.getText().toString().trim();
            if (!StringUtils.isEmpty(username) &&
                    !StringUtils.isEmpty(password)) {
                mvpPresenter.loginData(username, password);
            }
        });

        btnRegister.setOnClickListener(v -> ((LoginActivity) getActivity()).addFragment(RegisterFragment.newInstance("register"), R.string.register));
    }

    @Override
    protected void setUpData() {

    }


    @Override
    public void loginData(LoginModel data) {

    }

    @Override
    public void registerData(LoginModel data) {

    }

    @Override
    public void modifyData(List<Integer> data) {

    }

    @Override
    public void getDataFail(String msg) {
        showToast(msg);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

}
