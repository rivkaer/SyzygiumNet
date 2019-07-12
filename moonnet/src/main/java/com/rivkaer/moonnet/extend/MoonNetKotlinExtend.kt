package com.rivkaer.moonnet.extend

import android.content.Context
import com.rivkaer.moonnet.loader.NetworkLoader
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author: Junjian Jia
 * @Date: 2019/7/10 20:06
 * @Email: cnrivkaer@outlook.com
 * @Description: moonnet 简化拓展
 */
fun <T> Observable<T>.defaultSetting(): Observable<T> {
    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.loadingSetting(context: Context): Observable<T> {
    return this.subscribeOn(Schedulers.io())
        .doOnSubscribe { NetworkLoader.showLoading(context) }
        .subscribeOn(AndroidSchedulers.mainThread())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnTerminate { NetworkLoader.stopLoading() }
}