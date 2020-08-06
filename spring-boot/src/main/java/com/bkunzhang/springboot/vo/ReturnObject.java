package com.bkunzhang.springboot.vo;

/**
 * @author bingkun_zhang
 * @date 2020/6/9
 */
public class ReturnObject<T> {
    private int code;
    private String msg;
    private T data;

    @Override
    public String toString() {
        return "ReturnObject{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public ReturnObject() {}

    public ReturnObject(ReturnCode returnCode, T data) {
        this.code = returnCode.getCode();
        this.msg = returnCode.getMessage();
        this.data = data;
    }

    public ReturnObject(ReturnCode rc) {
        this.code = rc.getCode();
        this.msg = rc.getMessage();
    }

    public static ReturnObject success(Object data) {
        return new ReturnObject(ReturnCode.C200, data);
    }

    public ReturnObject(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ReturnObject msg(String msg) {
        this.msg = msg;
        return this;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
