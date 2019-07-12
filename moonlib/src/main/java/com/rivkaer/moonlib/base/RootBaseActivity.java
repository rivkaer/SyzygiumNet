package com.rivkaer.moonlib.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.Unbinder;
//import com.githang.statusbar.StatusBarCompat;

/**
 * @author: Junjian Jia
 * @Date: 2019/7/6 15:31
 * @Email: cnrivkaer@outlook.com
 * @Description: 基本的活动
 */
public abstract class RootBaseActivity extends AppCompatActivity {

    protected final String TAG = getClass().getName().toString();

    private Unbinder unbinder;

    /**
     * 活动上下文
     */
    protected Context mContext;

    /**
     * 得到活动上下文
     *
     * @return 活动上下文
     */
    public Context getContext() {
        if (mContext == null) {
            return this;
        }
        return mContext;
    }

    /**
     * 设置布局资源
     *
     * @return 活动布局资源
     */
    protected abstract @NonNull
    Object setLayoutRes();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化页面
     */
    protected abstract void initView();

    /**
     * 得到活动传递的参数
     *
     * @param bundle savedInstanceState
     * @param intent 上个活动传递的参数
     */
    protected void onArgument(Bundle bundle, @NonNull Intent intent) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThisContentView(setLayoutRes());
        onSettingBar();

        mContext = this;

        /**
         * 活动参数
         */
        Intent intent = getIntent();
        if (intent != null) {
            onArgument(savedInstanceState, intent);
        }

        bindThisView();
        initData();
        initView();
    }

    /**
     * 设置当前活动的内容
     *
     * @param contentObj 内容资源
     */
    private void setThisContentView(Object contentObj) {
        if (contentObj == null) {
            throw new NullPointerException(TAG + ": not setting this activity content layout resource!!!");
        }

        if (contentObj instanceof Integer) {
            setContentView((Integer) contentObj);
        } else if (contentObj instanceof View) {
            setContentView((View) contentObj);
        } else {
            throw new IllegalArgumentException(TAG + " : not search setting this activity content layout resource type!!! current type : " + contentObj.getClass().getName());
        }
    }

    /**
     * 默认设置状态栏等状态
     */
    protected void onSettingBar() {
//        StatusBarCompat.setTranslucent(getWindow(), true);
//        StatusBarCompat.resetActionBarContainerTopMargin(getWindow());
    }

    /**
     * 设置状态栏颜色是非为深色
     *
     * @param isLight 是否为深色
     */
    protected void onSettingLightStatusBar(boolean isLight) {
//        StatusBarCompat.setLightStatusBar(getWindow(), isLight);
    }

    /**
     * 绑定当前的上下文
     */
    private void bindThisView() {
        unbinder = ButterKnife.bind(this);
    }

    /**
     * 解绑当前的上下文
     */
    private void unBindThisView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unBindThisView();
    }
}
