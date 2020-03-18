package com.yyw.bookExchange.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ReturnWrap<S> {
    public static final ReturnWrap<Void> SUCCEED = new ReturnWrap<>(0,"",null);

    public static <T> ReturnWrap<T> returnWithData(T o)  {
        return new ReturnWrap<>(0,"",o);
    }

    public static ReturnWrap<Void> errorWithData(String s)  {
        return new ReturnWrap<>(-1,s,null);
    }

    int code;

    public ReturnWrap(int code, String error, S data) {
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

    public S getData() {
        return data;
    }

    public void setData(S data) {
        this.data = data;
    }

    String error;
    S data;
}
