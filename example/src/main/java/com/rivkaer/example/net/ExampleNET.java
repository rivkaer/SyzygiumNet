package com.rivkaer.example.net;

import com.rivkaer.example.app.MoonNet;
import com.rivkaer.example.net.service.ExampleService;
import com.rivkaer.moonnet.retrofit.RetrofitManager;

/**
 * @author: Rivkaer Jia
 * @Date: 2019/4/21
 * @Email: cnrivkaer@outlook.com
 * @Description: 网路工具
 */
public class ExampleNET {

    private static ExampleService exampleApi() {
        return RetrofitManager.getInstance().newRetrofit(MoonNet.getApiHost(), MoonNet.isDebug()).create(ExampleService.class);
    }

    /* 测试Api */
    public static ExampleService exampleNet() {
        return exampleApi();
    }
}
