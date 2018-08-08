package com.wind.valley.common.message;

import com.alibaba.fastjson.JSON;

public class ReturnMessage<T> {
    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getDada() {
        return data;
    }

    public void setDada(T data) {
        System.out.println(JSON.toJSONString(data));
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
