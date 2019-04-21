package com.rivkaer.moonnet.retrofit;

import com.rivkaer.moonnet.MoonNet;
import com.rivkaer.moonnet.convert.GsonConverterFactory;
import com.rivkaer.moonnet.okhttp.OKHttpManager;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author: Rivkaer Jia
 * @Date: 2019/4/21
 * @Email: cnrivkaer@outlook.com
 * @Description: Retrofit 管理器
 */
public final class RetrofitManager {

    private static Retrofit mRetrofit;

    private RetrofitManager() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(MoonNet.isDebug() ? MoonNet.getDebugHost() : MoonNet.getApiHost());
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.client(OKHttpManager.getInstance().getHttpClick());
        mRetrofit = builder.build();
    }

    public static RetrofitManager getInstance() {
        return RetrofitManagerHolder.instance;
    }

    private static final class RetrofitManagerHolder {
        static RetrofitManager instance = new RetrofitManager();
    }

    public Retrofit retrofit() {
        return mRetrofit;
    }
}
