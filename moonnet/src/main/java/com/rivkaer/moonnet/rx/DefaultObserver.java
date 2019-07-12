package com.rivkaer.moonnet.rx;

import java.net.ConnectException;
import java.net.UnknownHostException;

import com.rivkaer.moonnet.exception.ResultException;
import com.rivkaer.moonnet.model.BaseResultBean;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @author: Jia Junjian
 * @date: 2019/4/17
 * @email: cnrivkaer@outlook.com
 * @describe: 自定义Observer
 **/
public abstract class DefaultObserver<T> implements Observer<BaseResultBean<T>> {

    public DefaultObserver() {
    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {
        onFinish();
    }

    @Override
    public void onNext(BaseResultBean<T> tResultBean) {
        if (tResultBean.getCode() == 200) {
            onSuccess(tResultBean.getData());
        } else {
            int code = tResultBean.getCode();
            onFailure(code, "falure");
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof ResultException) {
            int code = ((ResultException) e).getCode();
            if (code == 200) {
                onSuccess(null);
            } else {
                onFailure(code, e.getMessage());
            }
        } else if (e instanceof HttpException || e instanceof UnknownHostException || e instanceof ConnectException) {
            onFailure(-1, "当前网络不可用，请检查网络连接");
        } else {
            onFailure(-1, "数据解析异常");
        }
        onFinish();
    }

    /**
     * 数据请求成功
     */
    protected abstract void onSuccess(T resp);

    /**
     * 数据请求失败
     */
    protected abstract void onFailure(int code, String message);

    /**
     * 完成请求
     */
    protected void onFinish() {

    }
}