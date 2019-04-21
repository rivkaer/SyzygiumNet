package com.rivkaer.moonnet.configurator;

import com.rivkaer.moonnet.helper.MoonStorageHelper;

import java.util.WeakHashMap;

/**
 * @author: Junjian Jia
 * @Date: 19-4-19
 * @Email: cnrivkaer@outlook.com
 * @Description: 初始化器
 */
public final class Configurator {

    private static final WeakHashMap<Object, Object> MOON_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        MOON_CONFIGS.put(ConfigType.CONFIG_READY, false);
    }

    private static final class ConfiguratorHolder {
        static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return ConfiguratorHolder.INSTANCE;
    }

    public final Configurator withDebug(boolean isDebug) {
        MOON_CONFIGS.put(ConfigType.IS_DEBUG, isDebug);
        return this;
    }

    public final Configurator withApiHost(String url) {
        MOON_CONFIGS.put(ConfigType.API_HOST, url);
        return this;
    }

    public final Configurator withDebugHost(String url) {
        MOON_CONFIGS.put(ConfigType.DEBUG_HOST, url);
        return this;
    }

    public final Configurator withCookieWareHouse(MoonStorageHelper helper) {
        MOON_CONFIGS.put(ConfigType.MOON_STORAGE, helper);
        return this;
    }

    /* 初始化完成 */
    public final void configurator() {
        MOON_CONFIGS.put(ConfigType.CONFIG_READY, true);
    }

    /* 获取初始化列表 */
    public final WeakHashMap<Object, Object> getMoonConfigs() {
        return MOON_CONFIGS;
    }

    /* 检查是否初始化完成 */
    private void checkConfiguration() {
        boolean isReady = (boolean) MOON_CONFIGS.get(ConfigType.CONFIG_READY);
        if (isReady) {
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }

    /* 检查获取的值是否已经初始化 */
    private void checkIsConfigurationOption(Object key) {
        boolean contains = MOON_CONFIGS.keySet().contains(key);
        if (contains) {
            throw new RuntimeException("Configuration is not configure the key --> " + key);
        }
    }

    /* 获取初始化数据 */
    @SuppressWarnings("unchecked")
    public final <T> T getConfiguration(Object key) {
        checkConfiguration();
        checkIsConfigurationOption(key);
        return (T) MOON_CONFIGS.get(key);
    }

    public static class ConfigType {
        public static final String IS_DEBUG = "IS_DEBUG";
        public static final String API_HOST = "API_HOST";
        public static final String DEBUG_HOST = "DEBUG_HOST";
        public static final String CONFIG_READY = "CONFIG_READY";
        public static final String MOON_STORAGE = "MOON_STORAGE";
    }
}
