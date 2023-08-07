package com.awei.controller;

public class Result {
    private Object date;
    private Integer code;
    private String msg;

    public Result(Object date, Integer code, String msg) {
        this.date = date;
        this.code = code;
        this.msg = msg;
    }

    public Result(Object date, Integer code) {
        this.date = date;
        this.code = code;
    }

    public Result(Integer code,  String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "date=" + date +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Object getDate() {
        return date;
    }


    public void setDate(Object date) {
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
