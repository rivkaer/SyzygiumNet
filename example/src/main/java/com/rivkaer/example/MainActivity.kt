package com.rivkaer.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rivkaer.example.base.bean.Types
import com.rivkaer.example.base.bean.Welfare
import com.rivkaer.example.ec.simple.SimpleExampleActivity
import com.rivkaer.example.net.GankioRetrofit
import com.rivkaer.moonnet.Callback.CustCallback
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple.setOnClickListener {
            startActivity(intentFor<SimpleExampleActivity>())
        }

        GankioRetrofit.Gankio().girls(Types.WELFARE.typeVal, 10, 1).enqueue(object : CustCallback<List<Welfare>>() {
            override fun onFailure(failureCode: Int, msg: String?, call: Call<List<Welfare>>?) {
                println(msg)
            }

            override fun onSuccess(t: List<Welfare>?) {
                print(t!![0].url)
            }
        })

    }
}
