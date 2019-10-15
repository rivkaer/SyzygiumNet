package com.rivkaer.example.local;

import com.rivkaer.example.constant.AppConstant;
import com.rivkaer.example.net.RetrofitManager;

import retrofit2.Retrofit;

/**
 * <p>@ProjectName:     WeedNet</p>
 * <p>@ClassName:       ExampleService</p>
 * <p>@PackageName:     com.rivkaer.example.local</p>
 * <b>
 * <p>@Description:     Class description</p>
 * </b>
 * <p>@author:          Rivkaer Jia</p>
 * <p>@date:            2019/10/15 21:31</p>
 * <p>@email:           cnrivkaer@outlook.com</p>
 */
public class ExampleService {

    private static Retrofit newRetrofit(){
        return RetrofitManager.getInstance().newRetrofit(AppConstant.BASE_HOST, AppConstant.STATUS_IS_OPEN_HTTP_REQUEST_LOG);
    }

    public static ApiService apis(){
        return newRetrofit().create(ApiService.class);
    }

}
