package com.rivkaer.moonnet.intercept;

import com.rivkaer.moonnet.helper.MoonStorageHelper;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Rivkaer Jia
 * @Date: 2019/4/21
 * @Email: cnrivkaer@outlook.com
 * @Description: Cookie 保存拦截器
 */
public class ReceivedCookiesInterceptor implements Interceptor {

    private MoonStorageHelper mWareHose;

    public ReceivedCookiesInterceptor() {
    }

    public ReceivedCookiesInterceptor(MoonStorageHelper wareHose) {
        this.mWareHose = wareHose;
    }

    public void setmWareHose(MoonStorageHelper mWareHose) {
        this.mWareHose = mWareHose;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            Set<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }

            mWareHose.saveCookie(mWareHose.NAME_SAVE_COOKIE, cookies);
        }

        return originalResponse;
    }
}
