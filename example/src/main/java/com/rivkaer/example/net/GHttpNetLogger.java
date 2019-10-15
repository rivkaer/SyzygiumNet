package com.rivkaer.example.net;

import android.util.Log;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * <p>@ProjectName:     WeedNet</p>
 * <p>@ClassName:       GHttpNetLogger</p>
 * <p>@PackageName:     com.rivkaer.example.net</p>
 * <b>
 * <p>@Description:     网络Logger</p>
 * </b>
 * <p>@author:          Rivkaer Jia</p>
 * <p>@date:            2019/10/15 20:53</p>
 * <p>@email:           cnrivkaer@outlook.com</p>
 */
public class GHttpNetLogger implements HttpLoggingInterceptor.Logger {

    private static final String TAG = "GHttpNetLogger";

    private static final HttpLoggingInterceptor.Level G_LOGGER_LEVEL = HttpLoggingInterceptor.Level.BODY;

    @Override
    public void log(String message) {
        Log.d(TAG, message);
    }

    public static HttpLoggingInterceptor.Level fetchLoggerLevel(){
        return G_LOGGER_LEVEL;
    }
}