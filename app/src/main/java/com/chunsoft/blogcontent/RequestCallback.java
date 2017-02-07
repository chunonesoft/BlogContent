package com.chunsoft.blogcontent;

/**
 * Developer：chunsoft on 2017/2/7 11:35
 * Email：chun_soft@qq.com
 * Content：回调接口
 */

public interface RequestCallback<T> {
    void onSuccess(T datas);
    void onFailure(String msg);
}
