package com.wangxy.repository.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by Wangxy on 2017/11/29.
 */
@SuppressWarnings({"unused", "Duplicates"})
@Configurable
public class SecondaryDataSourceConfig {
    /**
     * 数据库地址
     */
    @Value("${secondary.url}")
    private String url;
    /**
     * 用户名
     */
    @Value("${secondary.username}")
    private String username;
    /**
     * 密码
     */
    @Value("${secondary.password}")
    private String password;
    /**
     * 驱动
     */
    @Value("${secondary.driverClassName}")
    private String driverClassName;


    private int maxActive = 30;
    private int minIdle = 5;
    private int initialSize = 20;
    private int maxWait = 1000;

    private boolean removeAbandoned = true;
    private int removeAbandonedTimeout = 180;

    private final static Logger logger= LoggerFactory.getLogger(SecondaryDataSourceConfig.class);

    @Bean(name = "secondaryDS")
    @Qualifier("secondaryDS")
    @Primary
    public DataSource secondaryData(){
        if (StringUtils.isNotBlank(this.url)
                &&StringUtils.isNotBlank(this.username)
                &&StringUtils.isNotBlank(this.password)
                &&StringUtils.isNotBlank(this.driverClassName)){
            logger.info(
                    "--------primary数据库属性:  url:{},username:{},password:{},driverClassName:{}，maxActive:{}",
                    url, username, password, driverClassName, maxActive);
        }else {
            throw new RuntimeException(
                    "url,username,password,driverClassName is required");
        }

        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        dataSource.setUrl(this.url);
        dataSource.setDriverClassName(this. driverClassName);
        dataSource.setMaxActive(this.maxActive);
        dataSource.setMinIdle(this.minIdle);
        dataSource.setMaxWait(this.maxWait);
        dataSource.setInitialSize(this.initialSize);
        dataSource.setRemoveAbandoned(this.removeAbandoned);
        dataSource.setRemoveAbandonedTimeout(this.removeAbandonedTimeout);
        return dataSource;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public boolean isRemoveAbandoned() {
        return removeAbandoned;
    }

    public void setRemoveAbandoned(boolean removeAbandoned) {
        this.removeAbandoned = removeAbandoned;
    }

    public int getRemoveAbandonedTimeout() {
        return removeAbandonedTimeout;
    }

    public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
        this.removeAbandonedTimeout = removeAbandonedTimeout;
    }
}
