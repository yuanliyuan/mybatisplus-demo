package com.yl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
