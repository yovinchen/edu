package com.offcn.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offcn.edu.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
public interface UserMapper extends BaseMapper<User> {

    //用户登录方法
    User login(@Param("phone") String phone, @Param("password") String password);

    //根据登录用户名，获取用户信息
    User getUserByUsername(@Param("username") String username);

}
