package com.jiyu.dao.db02;

import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

public interface AccountMapper {
    @Update("update account set balance = balance + #{amount} where id = #{id}")
    int accountAddBalance(BigDecimal amount, Integer id);
}
