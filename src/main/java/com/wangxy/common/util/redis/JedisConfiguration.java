/**
 * jedisConfiguration.java created on 2017年8月7日 下午4:20:08
 * Copyright (c) 2017 by 浙江新能量科技有限公司
 */
package com.wangxy.common.util.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Title
 *
 * @author wxy
 * @version 1.0
 */

/**
 * @author wxy
 * @version 1.0
 * @value 数值类型 #{value} Title 文本类型$(value)
 */
@Component
public class JedisConfiguration {

    @Value("${redis.master.host}")
    private String host;

    @Value("${redis.master.port}")
    private Integer port;

    @Value("${redis.master.max.total}")
    private Integer maxTotal;

      @Value("${redis.master.max.idle}")
    private Integer maxIdle;

     @Value("${redis.master.max.waitmillis}")
    private Long maxWaitmillis;

     @Value("${redis.master.testOnBorrow}")
    private Boolean testOnBorrow;

    @Value("${redis.master.max.timeout}")
    private Integer maxTimeout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public void setMaxWaitmillis(Long maxWaitmillis) {
        this.maxWaitmillis = maxWaitmillis;
    }

    public Long getMaxWaitmillis() {
        return maxWaitmillis;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public Integer getMaxTimeout() {
        return maxTimeout;
    }

    public void setMaxTimeout(Integer maxTimeout) {
        this.maxTimeout = maxTimeout;
    }

    @Override
    public String toString() {
        return "JedisConfiguration [host=" + host + ", port=" + port
                + ", maxTotal=" + maxTotal + ", maxIdle=" + maxIdle
                + ", maxWaitmillis=" + maxWaitmillis + ", testOnBorrow="
                + testOnBorrow + ", maxTimeout=" + maxTimeout + "]";
    }

    /**
     * 初始化输出
     */
    @PostConstruct
     public void run(){
        System.err.println(toString());
    }
}
