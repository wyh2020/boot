package com.cl.boot;

/**
 * BusinessException
 * Created by MrC on 2017/6/20.
 */
public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException() {
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return super.getMessage();
    }
}
