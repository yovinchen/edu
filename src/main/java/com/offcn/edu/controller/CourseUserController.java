package com.offcn.edu.controller;


import com.offcn.edu.pojo.Course;
import com.offcn.edu.pojo.CourseUser;
import com.offcn.edu.pojo.User;
import com.offcn.edu.service.CourseService;
import com.offcn.edu.service.CourseUserService;
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

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
@Api(tags = "课程购买接口")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/edu/course-user")
public class CourseUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseUserService courseUserService;


    //课程购买接口
    @ApiOperation(value = "课程购买接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cid",value = "课程编号",required = true),
            @ApiImplicitParam(name = "username",value = "用户名",required = true)
    })
    @PostMapping("/")
    public String courseSale(Integer cid, String username) {

        //根据课程编号查询课程信息
        Course course = courseService.getById(cid);
        if (course == null) {
            return "null:";
        }

        //根据用户名，获取用户信息
        User user = userService.findUserByUserName(username);
        if (user == null) {
            return "null";
        }

        //获取用户编号
        Integer uid = user.getUid();
        //调用用户课程服务，新增用户购物记录

        //先验证该用户是否购买过该课程
        CourseUser courseUser1 = courseUserService.findEqualByCidUid(cid, uid);
        if (courseUser1!=null){
            return "error";
        }

        CourseUser courseUser = new CourseUser();
        courseUser.setCid(cid.intValue());
        courseUser.setUid(uid);

        courseUserService.save(courseUser);
        return "success";
    }
}

