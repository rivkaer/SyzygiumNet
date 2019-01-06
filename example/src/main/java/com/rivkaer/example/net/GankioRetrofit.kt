package com.rivkaer.example.net

import com.rivkaer.moonnet.RetrofitManage

class GankioRetrofit{

    companion object {
        private val GANKIO_URL:String = "http://gank.io/"

        private fun api():GankioApi{
            return RetrofitManage.getInstance().newRetrofit(GANKIO_URL).create(GankioApi::class.java)
        }

        public fun Gankio():GankioApi{
            return api()
        }
    }
}