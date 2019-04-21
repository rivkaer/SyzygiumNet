package com.rivkaer.moonnet.intercept;

import com.rivkaer.moonnet.helper.MoonStorageHelper;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Set;

/**
 * @author: Rivkaer Jia
 * @Date: 2019/4/21
 * @Email: cnrivkaer@outlook.com
 * @Description: 在请求头中增加Cookie
 */
public class AddCookiesInterceptor implements Interceptor {

    private MoonStorageHelper mWareHose;

    public AddCookiesInterceptor() {
    }

    public AddCookiesInterceptor(MoonStorageHelper wareHose) {
        this.mWareHose = wareHose;
    }

    public void setmWareHose(MoonStorageHelper mWareHose) {
        this.mWareHose = mWareHose;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();
        if (null != mWareHose) {
            Set<String> preferences = mWareHose.receiveCookie(mWareHose.NAME_SAVE_COOKIE);
            for (String cookie : preferences) {
                builder.addHeader("Cookie", cookie);
            }
        }
        return chain.proceed(builder.build());
    }
}
