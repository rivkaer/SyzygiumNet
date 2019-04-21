package com.rivkaer.moonnet.rx;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: Rivkaer Jia
 * @Date: 2019/4/21
 * @Email: cnrivkaer@outlook.com
 * @Description: 自定义Observable 增加默认线程实现
 */
public abstract class DefaultObservable<T> extends Observable<T> {

    public Observable<T> defaultThread() {
        return this.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
