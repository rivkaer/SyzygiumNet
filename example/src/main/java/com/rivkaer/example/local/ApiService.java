package com.rivkaer.example.local;

import com.rivkaer.example.bean.BaseRespBean;
import com.rivkaer.example.constant.AppConstant;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * <p>@ProjectName:     WeedNet</p>
 * <p>@ClassName:       ApiService</p>
 * <p>@PackageName:     com.rivkaer.example.local</p>
 * <b>
 * <p>@Description:     上层数据接口仓库</p>
 * </b>
 * <p>@author:          Rivkaer Jia</p>
 * <p>@date:            2019/10/15 21:19</p>
 * <p>@email:           cnrivkaer@outlook.com</p>
 */
public interface ApiService {

    @GET(value = AppConstant.FUNC_HOST_REQ)
    Call<BaseRespBean<String>> reqGet(@Query(value = "val") String val);

    // #请求参数可以为实体
    @POST(value = AppConstant.FUNC_HOST_REQ)
    Call<BaseRespBean<String>> reqPost(@Body Map<String, String> par);

}
