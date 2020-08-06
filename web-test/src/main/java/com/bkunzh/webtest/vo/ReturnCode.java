package com.bkunzh.webtest.vo;

/**
 * @author bingkun_zhang
 * @date 2020/6/9
 */
public enum ReturnCode {
    C200(200, "success"),
    C400(400, "客户端参数错误");
    private final int code;
    private String message;

    private ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
