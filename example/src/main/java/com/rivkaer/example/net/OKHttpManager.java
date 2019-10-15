package com.rivkaer.example.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * <p>@ProjectName:     WeedNet</p>
 * <p>@ClassName:       OKHttpManager</p>
 * <p>@PackageName:     com.rivkaer.example.net</p>
 * <b>
 * <p>@Description:     OkHTTPClient 管理器</p>
 * </b>
 * <p>@author:          Rivkaer Jia</p>
 * <p>@date:            2019/10/15 20:42</p>
 * <p>@email:           cnrivkaer@outlook.com</p>
 */
public final class OKHttpManager {

    private OkHttpClient iClient;

    /**
     * OkHttpClient管理器
     * @return 管理器
     */
    public static OKHttpManager getInstance() {
        return OKHttpManagerHolder.HOLDER;
    }

    private static final class OKHttpManagerHolder {
        private static OKHttpManager HOLDER = new OKHttpManager();
    }

    public OkHttpClient fetchHttpClient(boolean isOpenLogcat) {
        if (iClient == null) {
            OkHttpClient.Builder newBuilder = new OkHttpClient.Builder();
            if (isOpenLogcat) {
                newBuilder.addInterceptor(new HttpLoggingInterceptor(new GHttpNetLogger()).setLevel(GHttpNetLogger.fetchLoggerLevel()));
            }
            newBuilder.connectTimeout(15, TimeUnit.SECONDS);
            newBuilder.readTimeout(10, TimeUnit.SECONDS);
            newBuilder.writeTimeout(10, TimeUnit.SECONDS);
            newBuilder.followRedirects(true);
            iClient = newBuilder.build();
        }
        return iClient;
    }
}