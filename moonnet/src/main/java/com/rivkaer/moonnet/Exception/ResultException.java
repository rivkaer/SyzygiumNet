package com.rivkaer.moonnet.Exception;

/**
 * Create by JJ Jia on 2018/6/9
 */
public class ResultException extends RuntimeException {

    private int errorCode;

    /**
     * @param errorCode 判断错误
     * @param message   友好判断
     */
    public ResultException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int isErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return super.toString() + " , ResultException{" +
                "errorCode='" + errorCode + '\'' +
                '}';
    }

}
