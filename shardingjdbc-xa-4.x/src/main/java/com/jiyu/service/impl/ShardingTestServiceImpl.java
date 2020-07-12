package com.jiyu.service.impl;

import com.jiyu.dao.db01.UserMapper;
import com.jiyu.dao.db02.AccountMapper;
import com.jiyu.service.ShardingTestService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author zhongjingyun
 * @Date 2020/7/12 下午2:42
 **/
@Service
public class ShardingTestServiceImpl implements ShardingTestService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    AccountMapper accountMapper;

    @Override
    @ShardingTransactionType(TransactionType.XA)
    @Transactional
    public void testTransaction() {
        int userResult = userMapper.updateUserName("jiyuge", 1);
        int accountResult = accountMapper.accountAddBalance(BigDecimal.ONE, 1);
        System.out.println("用户表返回数量：" + userResult);
        System.out.println("账户表返回数量："+ accountResult);
//        throw new RuntimeException("我是一个异常");
    }
}
