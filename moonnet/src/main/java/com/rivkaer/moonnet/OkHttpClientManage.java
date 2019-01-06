package com.rivkaer.moonnet;

import java.util.concurrent.TimeUnit;

import com.rivkaer.moonnet.Interceptor.InterceptionNotNetwork;
import com.rivkaer.moonnet.Interceptor.InterceptorHeaderAdditionParameter;
import com.rivkaer.moonnet.Utils.HttpsUtils;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Create by JJ Jia on 2018/6/9
 *
 * function: OkHttp Unite Manage
 */
public class OkHttpClientManage {
    private static final long DEFAULT_READ_TIMEOUT_MILLIS = 15 * 1000;
    private static final long DEFAULT_WRITE_TIMEOUT_MILLIS = 20 * 1000;
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 20 * 1000;

    private static volatile OkHttpClientManage sInstance;
    private static OkHttpClient okHttpClient;

    private OkHttpClientManage() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new InterceptionNotNetwork());
        builder.addInterceptor(new InterceptorHeaderAdditionParameter());

        if (NetworkConfig.REQUEST_DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        builder.connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        builder.readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        builder.writeTimeout(DEFAULT_WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);

        builder.retryOnConnectionFailure(true);

        builder.followRedirects(true); //Allow Request Redirect

        builder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(), HttpsUtils.initTrustManager());

        okHttpClient = builder.build();
    }

    public static OkHttpClient getInstance() {
        if (null == sInstance) {
            synchronized (OkHttpClientManage.class) {
                if (null == sInstance)
                    sInstance = new OkHttpClientManage();
            }
        }
        return okHttpClient;
    }
}
