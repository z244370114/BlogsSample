package com.zy.blogs.blogssample.fragment;

import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.ProgressBar;

import com.blankj.utilcode.utils.StringUtils;
import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.activity.LoginActivity;
import com.zy.blogs.blogssample.model.LoginModel;
import com.zy.blogs.blogssample.mvp.MvpFragment;
import com.zy.blogs.blogssample.mvp.main.LoginPresenter;
import com.zy.blogs.blogssample.mvp.main.LoginView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * <p/>
 * 作者：zhouyuan on  2016/9/22 10:26
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public class RegisterFragment extends MvpFragment<LoginPresenter> implements LoginView {

    @Bind(R.id.et_username)
    TextInputEditText etUsername;
    @Bind(R.id.et_userpassword)
    TextInputEditText etUserpassword;
    @Bind(R.id.et_email)
    TextInputEditText etEmail;
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
        return R.layout.fragment_register;
    }

    @Override
    protected void setUpContentView() {
    }

    @Override
    protected void setUpData() {

    }

    @OnClick(R.id.btn_register)
    public void setBtnRegister() {
        String username = etUsername.getText().toString().trim();
        String password = etUserpassword.getText().toString().trim();
        if (!StringUtils.isEmpty(username) &&
                !StringUtils.isEmpty(password)) {
            mvpPresenter.registerData(username, password);
        }
    }

    @Override
    public void loginData(LoginModel data) {

    }

    @Override
    public void registerData(LoginModel data) {
        showToast(data.getUsername() + "\n" + data.getPassword());
        ((LoginActivity) getActivity()).removeFragment();
    }

    @Override
    public void getDataFail(String msg) {
        showToast(msg);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


}
