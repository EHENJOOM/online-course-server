package com.zhk.entity.vo;

/**
 * @author 赵洪苛
 * @date 2020/8/5 20:07
 * @description 服务器向Web返回的统一数据对象
 */
public class CommonResultVo<T> {

    private int code;
    private String message;
    private T data;

    public CommonResultVo() { }

    public CommonResultVo(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResultVo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
