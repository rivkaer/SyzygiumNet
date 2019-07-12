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
                .withApiHost("http://api.vnis.top")
                .withDebugHost("http://test.vnis.top")
                .withDebug(true)
                .withCookieWareHouse(new CookieStorage())
                .configurator();
    }
}
