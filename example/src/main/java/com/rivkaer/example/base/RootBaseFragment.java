package com.rivkaer.example.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author: Junjian Jia
 * @Date: 2019/7/6 18:08
 * @Email: cnrivkaer@outlook.com
 * @Description: 基础的碎片
 */
public abstract class RootBaseFragment extends Fragment {

    private final String TAG = this.getClass().getName();

    /**
     * 碎片依赖的活动
     */
    protected Activity mActivity;

    /**
     * 碎片上下文
     */
    protected Context mContext;

    /**
     * 黄油刀绑定
     */
    private Unbinder unbinder;

    /**
     * 页面主布局
     */
    protected View rootView;

    /**
     * 获取碎片主视图
     */
    protected abstract @NonNull
    Object setLayoutRes();

    /**
     * 初始化碎片传递数据
     *
     * @param savedInstanceState 切换保存数据
     * @param arguments          传递数据
     */
    protected void onArgument(Bundle savedInstanceState, Bundle arguments){

    };

    /**
     * 初始化碎片数据
     */
    protected abstract void initData();

    /**
     * 初始化页面视图
     */
    protected abstract void initView();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Object layoutRes = setLayoutRes();
        rootView = setThisContentView(layoutRes, inflater, container);
        unbinder = ButterKnife.bind(this, rootView);

        Bundle arguments = getArguments();
        if (arguments != null){
            onArgument(savedInstanceState, arguments);
        }

        return rootView;
    }

    /**
     * 设置当前碎片视图
     *
     * @param layoutRes 视图资源
     * @param inflater  加载器
     * @param container 容器
     * @return 碎片主视图
     */
    private View setThisContentView(Object layoutRes, LayoutInflater inflater, ViewGroup container) {
        View tempRootView;
        if (layoutRes != null) {
            if (layoutRes instanceof Integer) {
                tempRootView = inflater.inflate((Integer) layoutRes, container, false);
            } else if (layoutRes instanceof View) {
                tempRootView = (View) layoutRes;
            } else {
                throw new IllegalArgumentException(TAG + ": not search setting th content view resource type !!!");
            }
        } else {
            throw new NullPointerException(TAG + ": not setting this content view resource!!!");
        }
        return tempRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
