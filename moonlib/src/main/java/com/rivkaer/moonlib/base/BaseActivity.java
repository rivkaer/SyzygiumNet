package com.rivkaer.moonlib.base;

import android.app.Activity;
import android.support.annotation.StringRes;

import android.widget.Toast;

/**
 * @author: Junjian Jia
 * @Date: 2019/7/6 17:20
 * @Email: cnrivkaer@outlook.com
 * @Description: 本地化基础的活动
 */
public abstract class BaseActivity extends RootBaseActivity {


    /**
     * 弹出简单提示
     *
     * @param msg 提示信息
     */
    protected void showToast(String msg) {
        if (msg == null || !msg.isEmpty())
            return;

        Toast.makeText(mContext == null ? this : mContext, msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出简单提示
     *
     * @param msgRes 提示信息资源id
     */
    protected void showToast(@StringRes int msgRes) {
        String msg = getResources().getString(msgRes);
        showToast(msg);
    }
}