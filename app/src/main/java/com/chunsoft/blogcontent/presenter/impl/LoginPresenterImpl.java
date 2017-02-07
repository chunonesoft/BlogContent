package com.chunsoft.blogcontent.presenter.impl;

import android.os.Handler;

import com.chunsoft.blogcontent.RequestCallback;
import com.chunsoft.blogcontent.bean.User;
import com.chunsoft.blogcontent.model.LoginModel;
import com.chunsoft.blogcontent.model.impl.LoginModelImpl;
import com.chunsoft.blogcontent.presenter.LoginPresenter;
import com.chunsoft.blogcontent.view.LoginView;


/**
 * Developer：chunsoft on 2017/2/7 11:50
 * Email：chun_soft@qq.com
 * Content：
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginModel loginModel;

    private Handler mHandler = new Handler();

    //在构造函数中初始化
    public LoginPresenterImpl(LoginView loginView) {
        this.loginModel = new LoginModelImpl();
        this.loginView = loginView;
    }

    @Override
    public void login() {
        loginView.showLoading();
        loginModel.login(loginView.getUserName(), loginView.getPassword(), new RequestCallback<User>() {
            @Override
            public void onSuccess(final User datas) {
                //登录成功
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActvity(datas);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void onFailure(final String msg) {
                //登录失败
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError(msg);
                        loginView.hideLoading();
                    }
                });

            }
        });
    }
}
