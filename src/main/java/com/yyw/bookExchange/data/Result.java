package com.yyw.bookExchange.data;


public class Result {
    public Result(int status, String tocken) {
        this.status = status;
        this.tocken = tocken;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTocken() {
        return tocken;
    }

    public void setTocken(String tocken) {
        this.tocken = tocken;
    }

    private int status;
    private String tocken;

}
