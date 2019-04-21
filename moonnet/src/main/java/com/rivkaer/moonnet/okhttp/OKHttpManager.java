package com.rivkaer.moonnet.okhttp;

import com.rivkaer.moonnet.MoonNet;
import com.rivkaer.moonnet.helper.IMoonCoookieStorage;
import com.rivkaer.moonnet.intercept.AddCookiesInterceptor;
import com.rivkaer.moonnet.intercept.ReceivedCookiesInterceptor;
import com.rivkaer.moonnet.logger.MoonLogger;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author: Junjian Jia
 * @Date: 19-4-20
 * @Email: cnrivkaer@outlook.com
 * @Description: OKHttp 管理器
 */
public class OKHttpManager {

    private static OkHttpClient mOkHttpClick;

    private OKHttpManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (MoonNet.isDebug()) {
            builder.addInterceptor(new HttpLoggingInterceptor(new MoonLogger()).setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        IMoonCoookieStorage cookieWareHouse = MoonNet.getCookieWareHouse();
        if (null != cookieWareHouse) {
            builder.addInterceptor(new AddCookiesInterceptor(cookieWareHouse));
            builder.addInterceptor(new ReceivedCookiesInterceptor(cookieWareHouse));
        }

        builder.followRedirects(true);

        mOkHttpClick = builder.build();
    }

    public static OKHttpManager getInstance() {
        return OKHttpManagerHolder.instance;
    }

    private static class OKHttpManagerHolder {
        static final OKHttpManager instance = new OKHttpManager();
    }

    public OkHttpClient getHttpClick() {
        return mOkHttpClick;
    }
}
