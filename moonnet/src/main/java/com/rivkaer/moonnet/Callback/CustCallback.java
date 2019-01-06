package com.rivkaer.moonnet.Callback;

import com.rivkaer.moonnet.Exception.ApiException;
import com.rivkaer.moonnet.Exception.ResultException;
import com.rivkaer.moonnet.NetworkConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CustCallback<T> implements Callback<T> {

    public abstract void onSuccess(T t);

    public abstract void onFailure(int failureCode, String msg, Call<T> call);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            switch (response.code()){   // 请求失败code
                case 401:
                    onFailure(NetworkConfig.RESP_CODE_SERVER_EXCEPTION,"请登录后操作",call);
                    break;
                case 404:
                    onFailure(NetworkConfig.RESP_CODE_SERVER_EXCEPTION,"服务器无法提供此服务",call);
                    break;
                case 500:
                    onFailure(NetworkConfig.RESP_CODE_SERVER_EXCEPTION,"服务器异常",call);
                    break;
            }
        }

        //关闭统一开启的加载动画
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {      //resp 返回失败code
        if (t instanceof ResultException) {
            onFailure(NetworkConfig.RESP_CODE_FAILURE, t.getMessage(), call);
        } else if (t instanceof ApiException) {
            onFailure(NetworkConfig.RESP_CODE_TOKEN, t.getMessage(), call);
        }

        //关闭统一开启的加载动画
    }
}
