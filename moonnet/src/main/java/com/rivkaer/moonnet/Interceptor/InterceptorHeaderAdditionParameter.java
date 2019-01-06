package com.rivkaer.moonnet.Interceptor;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Create by JJ Jia on 2018/6/8
 * OkHttp Auto add Header Interceptor
 */
public class InterceptorHeaderAdditionParameter implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Headers.Builder headers = request.headers().newBuilder();
        headers.add("Content-type", "application/json");
        headers.add("Accept", "application/json");
        //统一追加Token
        String token = "123456";
        if (!TextUtils.isEmpty(token)){
            headers.add("token",token);
        }

        Headers newHeaders = headers.build();

        Request newRequest = request.newBuilder()
                .headers(newHeaders)
                .build();

        return chain.proceed(newRequest);
    }
}
