package com.rivkaer.example.base

interface IBaseModel<T> {

    interface ICallback<V> {
        fun over(msg: V)
        fun error(code: Int, error: String)
    }

    fun rquestGankio(type: String, size: Int, pager: Int, callBack: ICallback<T>)
}