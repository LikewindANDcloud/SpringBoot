package application.message;

import com.alibaba.fastjson.JSON;

public class ReturnMessage<T> {
    private String code;
    private String msg;
    private T dada;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getDada() {
        return dada;
    }

    public void setDada(T dada) {
        System.out.println(JSON.toJSONString(dada));
        this.dada = dada;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
