package com.rivkaer.example.ec.simple.impl

import android.app.Activity
import android.widget.Toast
import com.rivkaer.example.base.IBaseModel
import com.rivkaer.example.base.bean.Welfare
import com.rivkaer.example.ec.simple.ISimpleContract

class SimplePresenter : ISimpleContract.ISimplePresenter {

    var iView: ISimpleContract.ISimpleView? = null
    var iModel: ISimpleContract.ISimpleModel? = null

    override fun detachView() {
        this.iView = null
        this.iModel = null
    }

    override fun attachView(iView: ISimpleContract.ISimpleView) {
        this.iView = iView
        this.iModel = SimpleModelImpl()
    }

    override fun rquestGrils(inited: Boolean, size: Int, pager: Int) {
        iModel!!.rquestGankio("福利", size, pager, object : IBaseModel.ICallback<List<Welfare>> {
            override fun over(msg: List<Welfare>) {
                iView!!.load(inited, msg)
            }

            override fun error(code: Int, error: String) {
                Toast.makeText(iView as? Activity, "$code _ $error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}