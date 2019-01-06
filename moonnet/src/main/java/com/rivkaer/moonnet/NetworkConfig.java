package com.rivkaer.moonnet;

/**
 * Create by JJ Jia on 2018/6/9
 *
 * function: OKHTTP configure
 */
public class NetworkConfig {

    public static final boolean REQUEST_DEBUG = true;

    public static final boolean REQUEST_SUCCESS_CODE = false;
    public static final boolean REQUEST_NOT_NET_WORK_CODE = true;

    public static final int RESP_CODE_SUCCESS = 1;
    public static final int RESP_CODE_FAILURE = 0;
    public static final int RESP_CODE_TOKEN = 3;
    public static final int RESP_CODE_SERVER_EXCEPTION = 4;

}
