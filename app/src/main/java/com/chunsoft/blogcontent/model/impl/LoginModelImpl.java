package com.chunsoft.blogcontent.model.impl;

import com.chunsoft.blogcontent.RequestCallback;
import com.chunsoft.blogcontent.bean.User;
import com.chunsoft.blogcontent.model.LoginModel;

/**
 * Developer：chunsoft on 2017/2/7 11:31
 * Email：chun_soft@qq.com
 * Content：Model层的实现
 */

public class LoginModelImpl implements LoginModel{
    @Override
    public void login(final String username, final String password, final RequestCallback<User> callback) {
        //模仿登录操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("chunsoft".equals(username) && "123456".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    callback.onSuccess(user);
                } else {
                    callback.onFailure("登录失败");
                }
            }
        }.start();
    }
}
