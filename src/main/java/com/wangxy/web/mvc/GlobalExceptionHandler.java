package com.wangxy.web.mvc;

import com.wangxy.common.exception.AppException;
import com.wangxy.common.exception.BusinessException;
import com.wangxy.common.exception.msg.CommonMsgEnum;
import com.wangxy.common.util.response.ResponseDataPackageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * Created by Wangxy on 2017/11/29..
 *
 * @author wangxy
 */
@SuppressWarnings("ALL")
@RestControllerAdvice
//@ControllerAdvice
//@RestController
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基本业务异常处理
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public String businessExceptionHandler(HttpServletRequest req, BusinessException ex){
        logger.error("---host {} ERROR: {}", req.getRemoteHost(), ex.getMsg());
        return ResponseDataPackageUtils.fail(ex.getStatus(),ex.getMsg());
    }

    /**
     * app异常处理 （保留）
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = AppException.class)
    public String appExceptionHandler(HttpServletRequest req, AppException ex){
        logger.error("---host {} ERROR: {}", req.getRemoteHost(), ex.getMsg());
        return ResponseDataPackageUtils.fail(ex.getStatus(),ex.getMsg());
    }

    /**
     * 所有底层异常
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String baseErrorHandler(HttpServletRequest req,Exception ex){
        logger.error("---host {} ERROR: {}", req.getRemoteHost(), ex.getMessage());
        return ResponseDataPackageUtils.fail(CommonMsgEnum.SERVER_INTERNAL_ERROR.getStatus(),
                                            CommonMsgEnum.SERVER_INTERNAL_ERROR.getMsg());
    }


}
