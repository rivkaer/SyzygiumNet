package com.rivkaer.moonnet.exception;

/**
 * @author: Junjian Jia
 * @Date: 19-4-20
 * @Email: cnrivkaer@outlook.com
 * @Description: 自定义Exception携带出错信息
 */
public class ResultException extends RuntimeException {

    private int code;
    private String msg;

    public ResultException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
