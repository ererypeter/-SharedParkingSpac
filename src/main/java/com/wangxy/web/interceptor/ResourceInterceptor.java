package com.wangxy.web.interceptor;

import com.sun.jnlp.ApiDialog;
import com.wangxy.common.util.annotation.ApiRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by Wangxy on 2017/11/30..
 *
 * @author wangxy
 */
@Component("ResourceInterceptor")
public class ResourceInterceptor implements HandlerInterceptor {

    private Logger logger= LoggerFactory.getLogger(ResourceInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Method method = ((HandlerMethod) handler).getMethod();
        //登录权限拦截过滤器
       if (method.isAnnotationPresent(ApiRestController.class)){

       }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
