package com.rivkaer.example.net

import com.rivkaer.example.base.bean.Welfare
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GankioApi {

    @GET("api/data/{type}/{size}/{pager}")
    fun girls(@Path("type") type: String, @Path("size") size: Int, @Path("pager") pager: Int):Call<List<Welfare>>

}