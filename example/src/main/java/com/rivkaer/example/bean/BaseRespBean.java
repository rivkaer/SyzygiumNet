package com.rivkaer.example.bean;

/**
 * <p>@ProjectName:     WeedNet</p>
 * <p>@ClassName:       BaseRespBean</p>
 * <p>@PackageName:     com.rivkaer.example.bean</p>
 * <b>
 * <p>@Description:     基础响应实体</p>
 * </b>
 * <p>@author:          Rivkaer Jia</p>
 * <p>@date:            2019/10/15 21:21</p>
 * <p>@email:           cnrivkaer@outlook.com</p>
 */
public class BaseRespBean<T> {

    private int code;
    private String msg;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseRespBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
