package com.rivkaer.moonnet.rx;

import com.rivkaer.moonnet.exception.ResultException;
import com.rivkaer.moonnet.model.BaseResultBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: Junjian Jia
 * @Date: 19-4-20
 * @Email: cnrivkaer@outlook.com
 * @Description: 自定义Observer 剥离外层
 */
public abstract class DefaultObserver<T> implements Observer<BaseResultBean<T>> {

    private static final int CODE_SUCCESS = 200;

    /* 数据成功返回 */
    abstract void onSuccess(T data);

    /* 数据返回出错 */
    abstract void onFailure(int code, String msg);

    /* 数据返回结束 一般用于全局的加载动画关闭 */
    private void onFinish() {

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResultBean<T> tBaseResultBean) {
        if (tBaseResultBean.getCode() == CODE_SUCCESS) {
            onSuccess(tBaseResultBean.getData());
        } else {
            onFailure(tBaseResultBean.getCode(), tBaseResultBean.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ResultException) {
            onFailure(((ResultException) e).getCode(), ((ResultException) e).getMsg());
        } else {
            onFailure(-1, e.getMessage());
        }
    }

    @Override
    public void onComplete() {
        onFinish();
    }
}
