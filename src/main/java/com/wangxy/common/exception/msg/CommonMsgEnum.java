package com.wangxy.common.exception.msg;

/**
 *
 * 通用错误码 200 ok 成功返回状态 201 created 成功创建 304 not modified HTTP缓存有效 400 badrequest
 * 请求格式错误 401 unauthorized 未授权 403 forbidden 鉴权成功，但是该用户没有权限 404 not found
 * 请求的资源不存在 405 method not allowed 该http方法不被允许 410 gone 这个url对应的资源现在不可用 415
 * unsupported media type 请求类型错误 422 unprocessable entity 校验错误时用 429 too many
 * request 请求过多 500 inner error 服务器内部错误
 *
 * Created by Wangxy on 2017/11/29..
 *
 * @author wangxy
 */
public enum CommonMsgEnum {
    SUCESS(200, "成功"), SERVER_INTERNAL_ERROR(500, "服务器内部错误");

    private int status;
    private String msg;

    private CommonMsgEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
