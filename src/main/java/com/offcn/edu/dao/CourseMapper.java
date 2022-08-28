package com.offcn.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offcn.edu.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程表 Mapper 接口
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
public interface CourseMapper extends BaseMapper<Course> {

    //定义一个方法，根据指定课程类型获取课程列表
    List<Course> findCourseTypeTop8(@Param("typeId") Long typeId);

    //定义搜索方法：根据课程名称:搜索关键字
    List<Course> searchCourseName(@Param("keyword") String keyword);

    //定义一个方法，根据指定课程类型全部课程列表
    List<Course> findCourseTypeAll(@Param("typeId") Long typeId);

}
