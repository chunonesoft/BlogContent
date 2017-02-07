package com.chunsoft.blogcontent.view;

import com.chunsoft.blogcontent.bean.User;

/**
 * Developer：chunsoft on 2017/2/7 11:54
 * Email：chun_soft@qq.com
 * Content：
 */

public interface LoginView {
    String getUserName();
    String getPassword();

    void showLoading();
    void hideLoading();

    void toMainActvity(User user);
    void showFailedError(String msg);
}
