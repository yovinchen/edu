package com.offcn.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offcn.edu.dao.UserMapper;
import com.offcn.edu.pojo.User;
import com.offcn.edu.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User login(String phone, String password) {
        return this.baseMapper.login(phone, password);
    }

    @Override
    public User findUserByUserName(String username) {
        return this.baseMapper.getUserByUsername(username);
    }


}
