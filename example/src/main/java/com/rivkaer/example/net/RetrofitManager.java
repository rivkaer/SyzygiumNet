package com.rivkaer.example.net;

import com.rivkaer.example.net.conver.FastJsonConverterFactory;

import retrofit2.Retrofit;

/**
 * <p>@ProjectName:     WeedNet</p>
 * <p>@ClassName:       RetrofitManager</p>
 * <p>@PackageName:     com.rivkaer.example.net</p>
 * <b>
 * <p>@Description:     Retrofit管理器</p>
 * </b>
 * <p>@author:          Rivkaer Jia</p>
 * <p>@date:            2019/10/15 20:29</p>
 * <p>@email:           cnrivkaer@outlook.com</p>
 */
public final class RetrofitManager {

    private Retrofit iRetrofit;

    private RetrofitManager() {

    }

    /**
     * 单例获取Retrofit管理器
     * @return 管理器
     */
    public static RetrofitManager getInstance() {
        return RetrofitManagerHolder.HOLDER;
    }

    private static final class RetrofitManagerHolder {
        private static RetrofitManager HOLDER = new RetrofitManager();
    }

    public Retrofit newRetrofit(String host, boolean isOpenLogcat) {
        if (iRetrofit == null) {
            Retrofit.Builder newBuilder = new Retrofit.Builder();
            newBuilder.baseUrl(host);
            newBuilder.addConverterFactory(FastJsonConverterFactory.create());
            newBuilder.client(OKHttpManager.getInstance().fetchHttpClient(isOpenLogcat));
            iRetrofit = newBuilder.build();
        }
        return iRetrofit;
    }
}
