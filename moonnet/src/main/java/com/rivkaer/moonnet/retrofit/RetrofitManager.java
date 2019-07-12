package com.rivkaer.moonnet.retrofit;

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
    }

    public static RetrofitManager getInstance() {
        return RetrofitManagerHolder.instance;
    }

    private static final class RetrofitManagerHolder {
        static RetrofitManager instance = new RetrofitManager();
    }

    public Retrofit newRetrofit(String url, boolean isDebug) {
        if (mRetrofit == null) {
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(url);
            builder.addConverterFactory(GsonConverterFactory.create());
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            builder.client(OKHttpManager.getInstance().getHttpClick(isDebug));
            mRetrofit = builder.build();
        }
        return mRetrofit;
    }
}
