package com.rthttp.base;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date 2018/12/14 10:03
 *
 * 基础实体类
 */

public class BaseResponse<T> {

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
}
