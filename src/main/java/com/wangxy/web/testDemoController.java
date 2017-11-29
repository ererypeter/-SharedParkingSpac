package com.wangxy.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Wangxy on 2017/11/29.
 */
@SuppressWarnings("ALL")
@Controller
@EnableAutoConfiguration
public class testDemoController {

    @Value("${TestValue}")
    private String testValueAnno;


    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional(rollbackFor = RuntimeException.class,isolation =Isolation.REPEATABLE_READ,readOnly = false)
    public String test() {
        return "hello world "+testValueAnno;
    }



/*

    public static void main(String[] args){
        SpringApplication.run(testDemoController.class,args);
    }
*/

}
