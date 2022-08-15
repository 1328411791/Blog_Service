package com.lihanyu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lihanyu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<User> {


    @Select("select * from user where username = #{username} AND password = #{password}")
    public User loginUser(String username, String password);

    @Select("select * from user where username = #{username}")
    public User getUserByUsername(String username);


}
