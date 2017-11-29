package com.wangxy.threadlocal;

import com.wangxy.common.constant.DataSourceConsts;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wangxy on 2017/11/29..
 * 数据源设置
 * @author wangxy
 *
 */
public class DataSourceHolder {

    private final static ThreadLocal<String> DATA_SOURCE =new ThreadLocal<>();

    private final  static List<String> DATA_SORCECE_NAMES =new ArrayList<String>(){
        private static final long serialVersionUID = -7539786489841743864L;
        {
            /**添加数据源**/
            add(DataSourceConsts.PRIMARY_DS);
            add(DataSourceConsts.SECONDARY_DS);
        }
    };

    /**
     *设置数据源
     * @param dataSourceName
     */
    public static void setDataSource(String dataSourceName){
        DATA_SOURCE.set(dataSourceName);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String  getDataSource(){
        return DATA_SOURCE.get();
    }

    /**
     * 移除数据源
     */
    public static void  remove(){
        DATA_SOURCE.remove();
    }

    /**
     * 判断是否存在
     * @param dataSourceId
     * @return
     */
    public static boolean containsDataSource(String dataSourceId){
        return DATA_SORCECE_NAMES.contains(dataSourceId);
    }
}
