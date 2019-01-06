package com.rivkaer.example.ec.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rivkaer.example.R
import com.rivkaer.example.base.bean.Welfare
import com.rivkaer.example.ec.simple.impl.SimplePresenter

class SimpleExampleActivity : AppCompatActivity(), ISimpleContract.ISimpleView {

    private val simplePresenter: ISimpleContract.ISimplePresenter = SimplePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        simplePresenter.attachView(this)
    }

    override fun load(type: Boolean, list: List<Welfare>) {

    }

    override fun onDestroy() {
        super.onDestroy()
        simplePresenter.detachView()
    }
}
