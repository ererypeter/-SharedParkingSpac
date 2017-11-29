package com.wangxy.common.util.response;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.wangxy.common.constant.BusinessConsts;
import com.wangxy.common.exception.msg.CommonMsgEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wangxy on 2017/11/29..
 *
 * @author wangxy
 */
public class ResponseDataPackageUtils {

    private static final Map<Object, Object> EMPTY_MAP = ImmutableMap.builder()
            .build();

    private static Map<String, Object> map;

    private ResponseDataPackageUtils() throws Exception {
        throw new Exception();
    }

    static {
        //默认为success消息
        new HashMap<String, Object>();
        map.put(BusinessConsts.STATUS, CommonMsgEnum.SUCESS.getStatus());
        map.put(BusinessConsts.MSG, CommonMsgEnum.SUCESS.getMsg());
    }

    /**
     * 失败消息返回
     * @param status
     * @param msg
     * @return
     */
    public static  String fail(int status,String msg){
        Map<String,Object> map=new HashMap<>();
        map.put(BusinessConsts.STATUS,status);
        map.put(BusinessConsts.MSG,msg);
        map.put(BusinessConsts.DATA,EMPTY_MAP);
        return JSON.toJSONString(map);
    }

    /**
     * 不带数据的成功信息
     * @param status
     * @param msg
     * @return
     */
    public static String success(int status,String msg){
        map.put(BusinessConsts.DATA,EMPTY_MAP);
        return  JSON.toJSONString(map);
    }


    /**
     * 成功,不返回任何数据
     *
     * @return
     */
    public static String success() {
        map.put(BusinessConsts.DATA, EMPTY_MAP);
        return JSON.toJSONString(map);
    }

}
