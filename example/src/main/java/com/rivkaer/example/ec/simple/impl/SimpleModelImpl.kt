package com.rivkaer.example.ec.simple.impl

import com.rivkaer.example.base.IBaseModel
import com.rivkaer.example.base.bean.Types
import com.rivkaer.example.base.bean.Welfare
import com.rivkaer.example.ec.simple.ISimpleContract
import com.rivkaer.example.net.GankioRetrofit
import com.rivkaer.moonnet.Callback.CustCallback
import retrofit2.Call

class SimpleModelImpl : ISimpleContract.ISimpleModel {

    override fun rquestGankio(type: String, size: Int, pager: Int, callBack: IBaseModel.ICallback<List<Welfare>>) {
        GankioRetrofit.Gankio().girls(Types.WELFARE.typeVal, size, pager).enqueue(object : CustCallback<List<Welfare>>() {
            override fun onFailure(failureCode: Int, msg: String?, call: Call<List<Welfare>>?) {
                callBack.error(code = failureCode, error = "$msg")
            }

            override fun onSuccess(t: List<Welfare>?) {
                callBack.over(t!!)
            }
        })
    }
}