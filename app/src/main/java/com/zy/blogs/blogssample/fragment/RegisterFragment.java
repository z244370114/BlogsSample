package com.zy.blogs.blogssample.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.blankj.utilcode.utils.StringUtils;
import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.activity.LoginActivity;
import com.zy.blogs.blogssample.model.LoginModel;
import com.zy.blogs.blogssample.mvp.MvpFragment;
import com.zy.blogs.blogssample.mvp.main.LoginPresenter;
import com.zy.blogs.blogssample.mvp.main.LoginView;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * <p/>
 * 作者：zhouyuan on  2016/9/22 10:26
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 * 我这里同时用了 LoginPresenter是为了方便，不用重复生成一个 RegisterPresenter。 谅解
 */
public class RegisterFragment extends MvpFragment<LoginPresenter> implements LoginView {

    private static String ARG_REGISTER = "register";
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
    @Bind(R.id.et_newuserpassword)
    TextInputEditText etNewuserpassword;
    @Bind(R.id.new_password_layout)
    TextInputLayout newPasswordLayout;
    @Bind(R.id.email_layout)
    TextInputLayout emailLayout;
    private String mAction;

    public static RegisterFragment newInstance(String action) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle arg = new Bundle();
        arg.putString(ARG_REGISTER, action);
        fragment.setArguments(arg);
        return fragment;
    }

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
        mAction = getArguments().getString(ARG_REGISTER);
    }

    @Override
    protected void setUpData() {
        if (mAction.equals("register")) {
            emailLayout.setVisibility(View.VISIBLE);
            btnRegister.setText("注册");
        } else if (mAction.equals("modify")) {
            newPasswordLayout.setVisibility(View.VISIBLE);
            btnRegister.setText("修改");
        }
    }

    @OnClick(R.id.btn_register)
    public void setBtnRegister() {
        String username = etUsername.getText().toString().trim();
        String password = etUserpassword.getText().toString().trim();
        String npassword = etNewuserpassword.getText().toString().trim();
        if (!StringUtils.isSpace(username) &&
                !StringUtils.isSpace(password)) {
            if (mAction.equals("register")) {
                mvpPresenter.registerData(username, password);
            } else if (mAction.equals("modify")) {
                mvpPresenter.modifyData(username, password, npassword);
            }
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
    public void modifyData(List<Integer> data) {
        if (data.get(0) == 1) {
            showToast("修改成功！");
        }
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
