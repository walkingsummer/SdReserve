package com.SdReserve.bean;

/**
 * Created by zhangxz on 2017/7/26.
 */
public class SdBackResult {
    private boolean success;
    private String msg;
    private Object content;
    private Integer status;

    public SdBackResult(boolean success, String msg, Integer status, Object content) {
        this.success = success;
        this.msg = msg;
        this.content = content;
        this.status = status;
    }


    public static SdBackResult getSuccessResult(Object obj){
        return new SdBackResult(true,"ok", 0, obj);
    }

    public static SdBackResult getFailResult(String msg){
        return getFailResult(msg, -1);
    }

    public static SdBackResult getFailResult(String msg, Integer status){
        return new SdBackResult(false, msg, status, null);
    }

    public SdBackResult(){}

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
