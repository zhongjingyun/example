package com.jiyu.conf;


import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author zhongjingyun
 * @Date 2020/7/8 下午4:11
 **/
public class MyDatasourceRoutingAlgorithm implements HintShardingAlgorithm<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyDatasourceRoutingAlgorithm.class);


    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<String> shardingValue) {
        System.out.println("shardingValue=" + shardingValue);
        System.out.println("availableTargetNames=" + availableTargetNames);
        List<String> shardingResult = new ArrayList<>();
        for(String value : shardingValue.getValues()){
            if(availableTargetNames.contains(value)) {
                shardingResult.add(value);
            }
        }
        return shardingResult;
    }
}
