package com.rivkaer.moonnet.logger;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author: Junjian Jia
 * @Date: 19-4-20
 * @Email: cnrivkaer@outlook.com
 * @Description: 重写Logger接口格式化Log
 */
public class MoonLogger implements HttpLoggingInterceptor.Logger {

    private static final String TAG_LOGGER = "MoonNet - LOG";

    @Override
    public void log(String message) {
        Log.d(TAG_LOGGER, message);
    }
}
