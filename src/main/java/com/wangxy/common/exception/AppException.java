package com.wangxy.common.exception;

/**
 *
 * @author Wangxy
 * @date 2017/11/29
 */
public class AppException extends RuntimeException{

    private static final long serialVersionUID = 7179380341204080426L;

    private int status;

    private String msg;

    public AppException(int status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
