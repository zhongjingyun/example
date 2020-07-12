package com.jiyu.test;

import com.jiyu.service.ShardingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhongjingyun
 * @Date 2020/2/14 下午5:46
 **/
@RestController
public class DemoContraller {
    @Autowired
    ShardingTestService shardingTest;

    @RequestMapping("/demo")
    public String demo (){
        return "我是demo";
    }


    @RequestMapping("/sharding")
    public String sharding(){
        shardingTest.testTransaction();
        return "分布式事务提交成功success";
    }
}
