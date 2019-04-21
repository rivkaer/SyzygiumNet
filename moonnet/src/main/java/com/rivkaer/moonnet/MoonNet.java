package com.rivkaer.moonnet;

import com.rivkaer.moonnet.configurator.Configurator;
import com.rivkaer.moonnet.helper.MoonStorageHelper;

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
    public static boolean isConfigure() {
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

    /* 获取Cookie储存仓库 */
    public static MoonStorageHelper getCookieWareHouse() {
        if (!getConfiguations().keySet().contains(Configurator.ConfigType.MOON_STORAGE)) {
            return null;
        }
        return getConfiguration(Configurator.ConfigType.MOON_STORAGE);
    }

    private static <T> T getConfiguration(Object key) {
        return Configurator.getInstance().getConfiguration(key);
    }

    public static WeakHashMap<Object, Object> getConfiguations() {
        return Configurator.getInstance().getMoonConfigs();
    }
}
