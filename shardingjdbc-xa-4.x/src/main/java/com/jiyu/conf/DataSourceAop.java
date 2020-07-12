package com.jiyu.conf;


import org.apache.shardingsphere.api.hint.HintManager;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description 结合MyDatasourceRoutingAlgorithm，强制路由，自动切换数据源
 * @Author zhongjingyun
 * @Date  2020/7/9 上午2:13
 * @Param
 * @return
 **/
@Aspect
@Order(1)
@Component
public class DataSourceAop {
    public static final Logger logger = LoggerFactory.getLogger(DataSourceAop.class);
    /**
     * db01库切入点,读写分离又shadingjdbc控制
     */
    @Pointcut("execution(* com.jiyu.dao.db01..*.*(..))")
    public void switchDataSourceDb01() {
    }

    @Before("switchDataSourceDb01()")
    public void doDb01Before() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue("ds_db01");
    }

    /**
     * 恢复默认数据源
     */
    @After("switchDataSourceDb01()")
    public void doDb01after() {
        //清理掉当前设置的数据源，让默认的数据源不受影响
        HintManager.clear();
    }

    /**
     * db02库切入点,读写分离又shadingjdbc控制
     */
    @Pointcut("execution(* com.jiyu.dao.db02..*.*(..))")
    public void switchDataSourceDb02() {
    }

    @Before("switchDataSourceDb02()")
    public void doDb02Before() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue("ds_db02");
    }

    /**
     * 恢复默认数据源
     */
    @After("switchDataSourceDb02()")
    public void doDb02after() {
        //清理掉当前设置的数据源，让默认的数据源不受影响
        HintManager.clear();
    }
}
