package com.yyw.bookExchange.dao;

public class ReturnWrap {
    public static final ReturnWrap SUCCEED = new ReturnWrap(0,"",null);

    public static ReturnWrap returnWithData(Object o)  {
        return new ReturnWrap(0,"",o);
    }

    public static ReturnWrap errorWithData(Object o)  {
        return new ReturnWrap(-1,o.toString(),null);
    }

    int code;

    public ReturnWrap(int code, String error, Object data) {
        this.code = code;
        this.error = error;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    String error;
    Object data;
}
