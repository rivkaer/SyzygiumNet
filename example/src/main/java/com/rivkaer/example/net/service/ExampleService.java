package com.rivkaer.example.net.service;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * @author: Junjian Jia
 * @Date: 2019/7/10 19:49
 * @Email: cnrivkaer@outlook.com
 * @Description: 测试网络服务
 */
public interface ExampleService {

    @POST(value = "/")
    Observable<String> test();

    @GET
    Observable<ResponseBody> urlImage(@Url String imageUrl);

}
