package com.rivkaer.moonnet.okhttp;

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

    }

    public static OKHttpManager getInstance() {
        return OKHttpManagerHolder.instance;
    }

    private static class OKHttpManagerHolder {
        static final OKHttpManager instance = new OKHttpManager();
    }

    public OkHttpClient getHttpClick(boolean isDebug) {
        if (mOkHttpClick == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (isDebug) {
                builder.addInterceptor(new HttpLoggingInterceptor(new MoonLogger()).setLevel(HttpLoggingInterceptor.Level.BODY));
            }
//        IMoonCoookieStorage cookieWareHouse = MoonNet.getCookieWareHouse();
//        if (null != cookieWareHouse) {
//            builder.addInterceptor(new AddCookiesInterceptor(cookieWareHouse));
//            builder.addInterceptor(new ReceivedCookiesInterceptor(cookieWareHouse));
//        }
            builder.followRedirects(true);
            mOkHttpClick = builder.build();
        }
        return mOkHttpClick;
    }
}
