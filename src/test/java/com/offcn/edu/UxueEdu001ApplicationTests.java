package com.offcn.edu;

import com.offcn.edu.dao.CourseMapper;
import com.offcn.edu.dao.CoursedetailMapper;
import com.offcn.edu.dao.UserMapper;
import com.offcn.edu.pojo.Course;
import com.offcn.edu.pojo.Coursedetail;
import com.offcn.edu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UxueEdu001ApplicationTests {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CoursedetailMapper coursedetailMapper;

    @Autowired
    private UserMapper userMapper;

    //测试首页展示方法
    @Test
    void testfindCourseType() {
        List<Course> courseList = courseMapper.findCourseTypeTop8(2L);
        for (Course course : courseList) {
            System.out.println(course);
        }
    }

    //测试课程搜索方法
    @Test
    public void testSearch(){
        String keyword="Java";
        List<Course> courseList = courseMapper.searchCourseName(keyword);
        for (Course course : courseList) {
            System.out.println(course);
        }
    }

    //测试根据课程id获取课程信息
    @Test
    public void testGetCourseByID(){
        Course course = courseMapper.selectById(1);
        System.out.println(course);
    }

    //测试根据cid获取对应课程详情集合
    @Test
    public void testfindAllByCidCoursedetails(){
        List<Coursedetail> coursedetailList = coursedetailMapper.findAllByCidCoursedetails(3L);
        for (Coursedetail coursedetail : coursedetailList) {
            System.out.println(coursedetail);
        }
    }

    //测试登录
    @Test
    public void testLogin(){
        User login = userMapper.login("13515823698", "123");
        System.out.println(login);
    }



}
