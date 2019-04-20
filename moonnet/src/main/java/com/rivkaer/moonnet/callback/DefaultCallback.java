package com.rivkaer.moonnet.callback;

import com.rivkaer.moonnet.exception.ResultException;
import com.rivkaer.moonnet.model.BaseResultBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author: Junjian Jia
 * @Date: 19-4-20
 * @Email: cnrivkaer@outlook.com
 * @Description: 自定义Callback 第一种剥离外层的方式 跟自定义Observer一样都是较为推荐的方式
 */
public abstract class DefaultCallback<T> implements Callback<BaseResultBean<T>> {

    private static final int CODE_SUCCESS = 200;

    /* 数据成功返回 */
    abstract void onSuccess(T data);

    /* 数据异常 */
    abstract void onFailure(Call<BaseResultBean<T>> call, int code, String msg);

    @Override
    public void onResponse(Call<BaseResultBean<T>> call, Response<BaseResultBean<T>> response) {
        if (response.isSuccessful()) {
            BaseResultBean<T> body = response.body();
            if (body.getCode() == CODE_SUCCESS) {
                onSuccess(body.getData());
            } else {
                onFailure(call, body.getCode(), body.getMsg());
            }
        } else {
            onFailure(call, -1, "请求失败");
        }
    }

    @Override
    public void onFailure(Call<BaseResultBean<T>> call, Throwable t) {
        if (t instanceof ResultException) {
            onFailure(call, ((ResultException) t).getCode(), ((ResultException) t).getMsg());
        } else {
            onFailure(call, -1, t.getMessage());
        }
    }
}
