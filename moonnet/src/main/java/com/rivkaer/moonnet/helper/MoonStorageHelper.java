package com.rivkaer.moonnet.helper;

import java.util.Set;

/**
 * @author: Rivkaer Jia
 * @Date: 2019/4/21
 * @Email: cnrivkaer@outlook.com
 * @Description: 网络库储存接口
 */
public interface MoonStorageHelper {

    public String NAME_SAVE_COOKIE = "MoonCookie";

    /* 保存Cookie */
    void saveCookie(String saveName, Set<String> cookies);

    /* 获取Cookie */
    Set<String> receiveCookie(String saveName);

}
