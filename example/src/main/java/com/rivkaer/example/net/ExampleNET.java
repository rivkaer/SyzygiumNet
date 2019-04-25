package com.rivkaer.example.net;

import com.rivkaer.moonnet.retrofit.RetrofitManager;
import com.rivkaer.moonnet.rx.DefaultObservable;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * @author: Rivkaer Jia
 * @Date: 2019/4/21
 * @Email: cnrivkaer@outlook.com
 * @Description: 网路工具
 */
public class ExampleNET {

    private static ExampleApi exampleApi() {
        return RetrofitManager.getInstance().retrofit().create(ExampleApi.class);
    }

    /* 测试Api */
    public static ExampleApi exampleNet() {
        return exampleApi();
    }

    public interface ExampleApi {

        @POST(value = "/")
        DefaultObservable<String> test();

        @GET
        Observable<ResponseBody> urlImage(@Url String imageUrl);

    }
}
