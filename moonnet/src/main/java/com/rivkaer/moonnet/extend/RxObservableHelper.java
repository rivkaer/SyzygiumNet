package com.rivkaer.moonnet.extend;

import android.content.Context;
import com.rivkaer.moonnet.loader.NetworkLoader;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: Jia Junjian
 * @date: 2019/5/10
 * @email: cnrivkaer@outlook.com
 * @describe: Rxjava Observer帮助类
 **/
public final class RxObservableHelper {

    public interface ICostomRxObservableLoding {
        /* 显示loading */
        void showLoading();

        /* 隐藏loading */
        void hideLoading();
    }

    /* 提供默认的设置方法简化使用 */
    public static <T> Observable<T> basicSettings(Observable<T> oldObserver) {
        return oldObserver.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /* 提供默认的设置方法简化使用 */
    public static <T> Observable<T> basicLoadingSettings(final Context mContext, Observable<T> oldObserver) {
        return oldObserver.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        NetworkLoader.showLoading(mContext);
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        NetworkLoader.stopLoading();
                    }
                });
    }

    /* 提供默认的设置方法简化使用 */
    public static <T> Observable<T> basicCostomLoadingSettings(Observable<T> oldObserver, final ICostomRxObservableLoding loding) {
        return oldObserver.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (loding != null) {
                            loding.showLoading();
                        }
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        loding.hideLoading();
                    }
                });
    }
}
