package com.jiyu.conf;

import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author zhongjingyun
 * @Date 2020/7/8 下午4:11
 **/
public class MyDatasourceRoutingAlgorithm implements HintShardingAlgorithm {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyDatasourceRoutingAlgorithm.class);

    /**
     * 自定义Hint 实现算法
     * 能够保证绕过Sharding-JDBC SQL解析过程
     * @param availableTargetNames
     * @param shardingValue 不再从SQL 解析中获取值，而是直接通过下面代码参数指定
     *         HintManager hintManager = HintManager.getInstance();
     *         hintManager.setDatabaseShardingValue("ds_exchange");
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ShardingValue shardingValue) {

        System.out.println("shardingValue=" + shardingValue);
        System.out.println("availableTargetNames=" + availableTargetNames);
        List<String> shardingResult = new ArrayList<>();
        ListShardingValue<String> tmpSharding = (ListShardingValue<String>) shardingValue;
        for(String value : tmpSharding.getValues()){
            if(availableTargetNames.contains(value)) {
                shardingResult.add(value);
            }
        }
        return shardingResult;
    }
}
