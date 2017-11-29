package com.wangxy.common.annotation;

import java.lang.annotation.*;

/**
 * Created by Wangxy on 2017/11/29.
 */
@SuppressWarnings("ALL")
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    /**
     * dataSourceName
     * @return
     */
    String value();
}
