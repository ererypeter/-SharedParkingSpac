package com.wangxy.common.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 登陆权限过滤
 * Created by Wangxy on 2017/11/30..
 *
 * @author wangxy
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiRestController {
    /**
     * 若为false则不拦截登录
     *
     * @see com.wangxy.web.interceptor.ResourceInterceptor
     *
     * @return
     */
    boolean isRight() default  false;
}
