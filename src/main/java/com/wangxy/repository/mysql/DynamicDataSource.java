package com.wangxy.repository.mysql;

import com.wangxy.common.constant.DataSourceConsts;
import com.wangxy.threadlocal.DataSourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Wangxy
 * @date 2017/11/29
 * 多数据源配置
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    @Autowired
    @Qualifier("primaryDS")
    private DataSource primaryDS;

    @Autowired
    @Qualifier("secondaryDS")
    private DataSource secondaryDS;

    private Map<Object, Object> dataSources;
    @PostConstruct
    public  void dataSourceInit(){
        if (!ObjectUtils.isEmpty(primaryDS)&&!ObjectUtils.isEmpty(secondaryDS)){
            dataSources=new ConcurrentHashMap<Object, Object>(2);
            dataSources.put(DataSourceConsts.PRIMARY_DS,primaryDS);
            dataSources.put(DataSourceConsts.SECONDARY_DS,secondaryDS);
        }else {
            throw new RuntimeException(
                    "primaryDS or secondaryDS  is required,but is null");
        }

        //数据源集
        setTargetDataSources(dataSources);

        //默认主数据源
        setDefaultTargetDataSource(primaryDS);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSource();
    }



    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
    }

    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
    }

    @Override
    protected DataSource determineTargetDataSource() {
        return super.determineTargetDataSource();
    }
}
