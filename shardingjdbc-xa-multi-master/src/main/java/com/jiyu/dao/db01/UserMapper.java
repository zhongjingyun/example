package com.jiyu.dao.db01;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Update("update user set username = #{username} where id = #{uid}")
    int updateUserName(String username, Integer uid);
}
