package com.lihanyu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lihanyu.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {


}
