package com.offcn.edu.controller;


import com.offcn.edu.pojo.Course;
import com.offcn.edu.pojo.CourseUser;
import com.offcn.edu.pojo.User;
import com.offcn.edu.service.CourseService;
import com.offcn.edu.service.CourseUserService;
import com.offcn.edu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程表 前端控制器
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
@Api(tags = "课程操作接口")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/edu/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseUserService courseUserService;

    //测试读取全部课程
    @GetMapping("/")
    public List<Course> findAll() {
        return courseService.list(null);
    }

    //正式接口1：据题目分类编号，获取对应题目前八条集合
    @ApiOperation(value = "据题目分类编号，获取给首页显示用的前8条对应题目集合")
    @ApiImplicitParam(name = "typeId", value = "分类编号", required = true, paramType = "path")
    @GetMapping("/items/{typeId}")
    public List<Course> findCourseType(@PathVariable("typeId") Long typeId) {
        return courseService.findCourseTypeTop8(typeId);
    }


    //正式接口2：搜索方法
    @ApiOperation(value = "题目搜索接口")
    @ApiImplicitParam(name = "keyword", value = "搜索关键字", paramType = "path", required = true)
    @GetMapping("/search/{keyword}")
    public List<Course> search(@PathVariable("keyword") String keyword) {
        return courseService.searchCourseName(keyword);
    }

    //正式接口3：根据课程编号，获取对应课程信息+课程详情集合
    @ApiOperation(value = "根据课程编号，获取对应课程信息+课程详情集合")
    @ApiImplicitParam(name = "id", value = "课程编号", paramType = "path", required = true)
    @GetMapping("/{id}")
    public Map<String, Object> findCourseInfo(@PathVariable("id") Long id) {
        return courseService.findCourseInfo(id);
    }

    //正式接口4：据题目分类编号，获取对应题目全部集合
    @ApiOperation(value = "据题目分类编号，获取给首页显示用的全部对应题目集合")
    @ApiImplicitParam(name = "typeId", value = "分类编号", required = true, paramType = "path")
    @GetMapping("/itemsall/{typeId}")
    public List<Course> findCourseAll(@PathVariable("typeId") Long typeId) {
        return courseService.findCourseTypeAll(typeId);
    }

    //根据指定用户名，获取当前用户购买课程
    @ApiOperation(value = "根据指定用户名，获取当前用户购买课程")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path")
    @GetMapping("/user/{username}")
    public List<Course> findCouseByUserName(@PathVariable("username") String username) {
        List<Course> courseList = new ArrayList<>();
        //调用用户服务，根据用户名获取用户对象
        User user = userService.findUserByUserName(username);
        if (user != null) {
            Integer uid = user.getUid();
            List<CourseUser> courseUserList = courseUserService.findCourseUserByUid(uid);
            //循环遍历集合
            for (CourseUser courseUser : courseUserList) {
                //根据课程编号，获取对应课程信息
                Course course = courseService.getById(courseUser.getCid());
                courseList.add(course);
            }
        }
        return courseList;
    }
}

