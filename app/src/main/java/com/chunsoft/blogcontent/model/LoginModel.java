package com.chunsoft.blogcontent.model;

import com.chunsoft.blogcontent.RequestCallback;
import com.chunsoft.blogcontent.bean.User;

/**
 * Developer：chunsoft on 2017/2/7 11:30
 * Email：chun_soft@qq.com
 * Content：Model层主要处理业务方法和实体模型
 */

public interface LoginModel {
    void login(String username, String password, RequestCallback<User> callback);
}
