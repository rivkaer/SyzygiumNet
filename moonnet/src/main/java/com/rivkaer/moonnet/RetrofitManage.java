package com.rivkaer.moonnet;

import com.rivkaer.moonnet.template.CustGsonConverterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Create by JJ Jia on 2018/6/9
 *
 * function: Unite Retrofit Manage
 */
public class RetrofitManage {
    private OkHttpClient httpClient;

    private RetrofitManage() {
        httpClient = OkHttpClientManage.getInstance();
    }

    public static RetrofitManage getInstance() {
        return InnerHodler.INSTACE;
    }

    public Retrofit newRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(CustGsonConverterFactory.create())
                .client(httpClient)
                .build();
    }

    private static class InnerHodler {
        private static RetrofitManage INSTACE = new RetrofitManage();
    }

}
