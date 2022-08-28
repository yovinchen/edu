package com.offcn.edu.controller;


import com.offcn.edu.pojo.User;
import com.offcn.edu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
@Api(tags = "用户操作接口")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/edu/user")
public class UserController {

    @Autowired
    private UserService userService;

    //正式接口：用户注册
    @ApiOperation(value = "用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
            @ApiImplicitParam(name = "repassword", value = "重复密码", required = true)
    })
    @PostMapping("/")
    public String register(String phone, String password, String repassword) {
        //判断二次输入密码是否相同
        if (password != null && repassword != null && password.equals(repassword)) {
            //发起注册，创建用户对象
            User user = new User();
            user.setPhone(phone);
            user.setUsername(phone);
            user.setName(phone);
            user.setPassword(password);
            user.setCreatetime(new Date());
            //调用用户服务,保存
            userService.save(user);
            return "成功";
        } else {
            return "失败";
        }
    }

    //正式接口2：用户登录接口
    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @PostMapping("/login")
    public User login(String phone, String password) {
        User user = userService.login(phone, password);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
}

