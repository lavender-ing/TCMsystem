package com.example.indexmanager.result;

public class Result {
    //结果状态
    private int code;
    //提示信息
    private String message;
    //处理结果
    private Object result;

    Result(int code){
        this.code = code;
    }

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
