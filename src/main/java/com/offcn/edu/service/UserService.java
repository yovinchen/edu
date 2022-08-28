package com.offcn.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offcn.edu.pojo.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
public interface UserService extends IService<User> {
    //调用登录
    User login(String phone,String password);

    //根据username获取用户信息
    User findUserByUserName(String username);
}
