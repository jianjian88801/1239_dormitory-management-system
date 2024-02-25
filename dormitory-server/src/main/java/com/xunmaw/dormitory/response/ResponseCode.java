package com.xunmaw.dormitory.response;

/**
 * 封装状态码及其描述信息
 */
public enum ResponseCode {//响应码
    SUCCESS(200,"SUCCESS"),
    ERROR(400,"ERROR"),
    NEED_LOGIN(302,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(414,"ILLEGAL_ARGUMENT");
    private final int code;
    private final String desc;
    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}