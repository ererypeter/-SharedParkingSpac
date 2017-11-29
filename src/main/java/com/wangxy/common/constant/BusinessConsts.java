package com.wangxy.common.constant;

/**
 * Created by Wangxy on 2017/11/29..
 *
 * @author wangxy
 */
@SuppressWarnings("ALL")
public interface BusinessConsts {

    String STATUS = "status";
    String MSG = "msg";
    String DATA = "data";

    String SUCCESS_MSG = "成功";
    String FAILUER_MSG = "失败";

    /**
     * web下业务抛出异常，转发到异常页面
     */
    String BUSINESS_EXCEPTION_FORWORD = "forward:businessException";

}
