package com.rivkaer.moonnet.template;

/**
 * Create by JJ Jia on 2018/6/17
 *
 * function: Json Unified outer stripping Base Bean
 */
public class BaseBean<T> {

    private int code;
    private String msg;
    private String time;
    private T data;

    public BaseBean() {
    }

    public BaseBean(int code, String msg, String time, T data) {
        this.code = code;
        this.msg = msg;
        this.time = time;
        this.data = data;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
