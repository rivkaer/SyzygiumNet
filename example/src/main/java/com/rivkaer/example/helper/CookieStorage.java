package com.rivkaer.example.helper;

import com.rivkaer.moonnet.helper.IMoonCoookieStorage;
import com.tencent.mmkv.MMKV;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Rivkaer Jia
 * @Date: 2019/4/21
 * @Email: cnrivkaer@outlook.com
 * @Description: 实现自己的 Cookie 存储接口
 * 项目使用的是 MMKV 一个有效的Key-value框架 link: https://github.com/Tencent/MMKV/wiki/android_setup
 */
public class CookieStorage implements IMoonCoookieStorage {

    @Override
    public void saveCookie(String saveName, Set<String> cookies) {
        MMKV mmkv = MMKV.defaultMMKV();
        mmkv.encode(saveName, cookies);
    }

    @Override
    public Set<String> receiveCookie(String saveName) {
        MMKV mmkv = MMKV.defaultMMKV();
        return mmkv.decodeStringSet(saveName, new HashSet<String>());
    }
}
