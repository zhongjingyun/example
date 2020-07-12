package com.jiyu.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhongjingyun
 * @Date 2020/2/14 下午5:46
 **/
@RestController
public class DemoContraller {

    @RequestMapping("/demo")
    public String demo (){
        return "我是demo";
    }
}
