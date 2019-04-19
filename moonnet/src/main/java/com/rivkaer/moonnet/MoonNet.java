package com.rivkaer.moonnet;

import com.rivkaer.moonnet.configurator.Configurator;

import java.util.WeakHashMap;

/**
 * @author: Junjian Jia
 * @Date: 19-4-19
 * @Email: cnrivkaer@outlook.com
 * @Description: 用于对网络框架进行初始化工作
 */
public class MoonNet {

    /* 开始初始化 */
    public static Configurator init() {
        return Configurator.getInstance();
    }

    /* 获取初始化器初始化状态 */
    public static boolean isConfigure(){
        return getConfiguration(Configurator.ConfigType.CONFIG_READY);
    }

    /* 当前是否处于测试环境 */
    public static boolean isDebug() {
        return getConfiguration(Configurator.ConfigType.IS_DEBUG);
    }

    /* 初始化Release主机域名 */
    public static String getApiHost() {
        return getConfiguration(Configurator.ConfigType.API_HOST);
    }

    /* 初始化Debug主机域名 */
    public static String getDebugHost() {
        return getConfiguration(Configurator.ConfigType.DEBUG_HOST);
    }

    /* 是否在头部自动绑定Token */
    public static boolean isAttachHeaderToken() {
        return getConfiguration(Configurator.ConfigType.ATTACH_TOKEN);
    }

    /* 获取自动绑定在头部的token */
    public static String getAttatchHeaderToken() {
        return getConfiguration(Configurator.ConfigType.TOKEN);
    }

    /* 刷新自动绑定在头部的token */
    public static void refreshAttachHeaderToken(String token) {
        Configurator.getInstance().getMoonConfigs().put(Configurator.ConfigType.TOKEN, token);
        Configurator.getInstance().getMoonConfigs().put(Configurator.ConfigType.ATTACH_COOKIE, true);
    }

    /* 是否在头部自动绑定Cookie */
    public static boolean isAttachHeaderCookie() {
        return getConfiguration(Configurator.ConfigType.ATTACH_COOKIE);
    }

    /* 获取自动绑定在头部的Cookie */
    public static String getAttatchHeaderCookie() {
        return getConfiguration(Configurator.ConfigType.COOKIE);
    }

    /* 刷新自动绑定在头部的Cookie */
    public static void refreshAttachHeaderCookie(String cookie) {
        Configurator.getInstance().getMoonConfigs().put(Configurator.ConfigType.COOKIE, cookie);
        Configurator.getInstance().getMoonConfigs().put(Configurator.ConfigType.ATTACH_COOKIE, true);
    }

    private static <T> T getConfiguration(Object key) {
        return Configurator.getInstance().getConfiguration(key);
    }

    public static WeakHashMap<Object, Object> getConfiguations() {
        return Configurator.getInstance().getMoonConfigs();
    }
}
