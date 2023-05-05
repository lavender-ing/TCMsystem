package com.example.indexmanager.result;

public class ResultFactory {
    public static Result makeResult(int code,String message,Object data){
        return new Result(code, message, data);
    }

    public static Result makeSuccessResult(Object data){
        return makeResult(ResultCode.SUCCESS, "成功！",data);
    }

    public static Result makeErrorResult(String message){
        return makeResult(ResultCode.FAIL,message,null);
    }
}
