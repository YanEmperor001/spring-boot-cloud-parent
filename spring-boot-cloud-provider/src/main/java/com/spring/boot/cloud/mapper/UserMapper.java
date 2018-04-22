package com.spring.boot.cloud.mapper;

import com.spring.boot.cloud.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    @Select(value = "select * from user where id = #{id}")
    @Results(value = {@Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
        @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
        @Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER)})
    public User searchUser(int id);
}
