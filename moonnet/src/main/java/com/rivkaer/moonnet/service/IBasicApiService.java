package com.rivkaer.moonnet.service;

import com.rivkaer.moonnet.model.ResultModel;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.*;

import java.util.Map;

public interface IBasicApiService {

    @GET
    <M> Observable<ResultModel<M>> executeGet(@Url String function);

    @GET
    <M> Observable<ResultModel<M>> executeGet(@Url String function, @QueryMap Map<String, Object> paramsMap);

    @POST
    <M> Observable<ResultModel<M>> executePost(@Url String function);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST
    <M> Observable<ResultModel<M>> executePost(@Url String function, @Body RequestBody body);

    @FormUrlEncoded
    @POST
    <M> Observable<ResultModel<M>> executePost(@Url String function, @FieldMap Map<String, Object> paramsMap);

}
