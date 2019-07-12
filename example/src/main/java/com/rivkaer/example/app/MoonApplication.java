package com.rivkaer.example.app;

import android.app.Application;
import com.rivkaer.example.helper.CookieStorage;
import com.tencent.mmkv.MMKV;

/**
 * @author: Rivkaer Jia
 * @Date: 2019/4/21
 * @Email: cnrivkaer@outlook.com
 * @Description: Application
 */
public class MoonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MMKV.initialize(this);

        initMoonNet();
    }

    private void initMoonNet() {
        MoonNet.init()
                .withApiHost("http://192.168.2.103:8061/") //http://net.novakj.cn
                .withDebug(true)
                .configurator();
    }
}
