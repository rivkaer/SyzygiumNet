package com.rivkaer.moonnet.Interceptor;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Create by JJ Jia on 2018/6/8
 * OkHttp Auto add Url Parameter Interceptor
 */
public class InterceptorUrlAdditionParameter implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl.Builder builder = request.url().newBuilder();

        HttpUrl newUrl = builder.build();

        Request newRequest = request.newBuilder()
                .url(newUrl)
                .build();

        return chain.proceed(newRequest);
    }
}
