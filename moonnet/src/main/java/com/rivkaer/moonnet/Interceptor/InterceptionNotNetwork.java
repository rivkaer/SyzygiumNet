package com.rivkaer.moonnet.Interceptor;

import java.io.IOException;

import com.rivkaer.moonnet.Exception.ResultException;
import com.rivkaer.moonnet.NetworkConfig;
import com.rivkaer.moonnet.Utils.IsNetworkUtils;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Create by JJ Jia on 2018/6/9
 *
 * function: OKHTTP Judging network status Interceptor
 */
public class InterceptionNotNetwork implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!IsNetworkUtils.isNetwork()) {
            return chain.proceed(chain.request());
        } else {
            throw new ResultException(NetworkConfig.RESP_CODE_SERVER_EXCEPTION, "连接超时,请检查网络");
        }
    }
}
