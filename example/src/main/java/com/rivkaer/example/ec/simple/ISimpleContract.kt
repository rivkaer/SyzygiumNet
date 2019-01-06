package com.rivkaer.example.ec.simple

import com.rivkaer.example.base.IBaseModel
import com.rivkaer.example.base.bean.Welfare

interface ISimpleContract {
    interface ISimpleView {
        fun load(type: Boolean, list: List<Welfare>)
    }

    interface ISimplePresenter {
        fun detachView()
        fun attachView(iView: ISimpleView)
        fun rquestGrils(inited:Boolean,size: Int, pager: Int)
    }

    interface ISimpleModel : IBaseModel<List<Welfare>>
}