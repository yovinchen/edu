package com.offcn.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offcn.edu.pojo.Course;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程表 服务类
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
public interface CourseService extends IService<Course> {

    //根据题目分类编号，获取对应题目前8条集合
    List<Course> findCourseTypeTop8(Long typeId);

    //根据课程名称:搜索关键字
    List<Course> searchCourseName(String keyword);

    //根据课程编号，获取课程信息和对应课程详情集合
    Map<String, Object> findCourseInfo(Long id);

    //根据题目分类编号，获取对应题目全部集合
    List<Course> findCourseTypeAll(Long typeId);

}
