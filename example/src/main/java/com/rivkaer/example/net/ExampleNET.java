package com.rivkaer.example.net;

import com.rivkaer.moonnet.retrofit.RetrofitManager;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * @author: Rivkaer Jia
 * @Date: 2019/4/21
 * @Email: cnrivkaer@outlook.com
 * @Description: 网路工具
 */
public class ExampleNET {

    private ExampleApi exampleApi() {
        return RetrofitManager.getInstance().retrofit().create(ExampleApi.class);
    }

    /* 测试Api */
    public ExampleApi exampleNet() {
        return exampleApi();
    }

    interface ExampleApi {

        @POST(value = "/")
        Observable<String> test();

    }
}
