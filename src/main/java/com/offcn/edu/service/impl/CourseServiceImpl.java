package com.offcn.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offcn.edu.dao.CourseMapper;
import com.offcn.edu.dao.CoursedetailMapper;
import com.offcn.edu.pojo.Course;
import com.offcn.edu.pojo.Coursedetail;
import com.offcn.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CoursedetailMapper coursedetailMapper;

    @Override
    public List<Course> findCourseTypeTop8(Long typeId) {
        return this.baseMapper.findCourseTypeTop8(typeId);
    }

    @Override
    public List<Course> searchCourseName(String keyword) {
        return this.baseMapper.searchCourseName(keyword);
    }

    @Override
    public Map<String, Object> findCourseInfo(Long id) {
        Map<String, Object> map=new HashMap<>();

        //调用课程数据访问接口，根据课程id获取课程信息
        Course course = this.baseMapper.selectById(id);
        //根据课程编号，去查询对应课程详情集合数据
        List<Coursedetail> coursedetailList = coursedetailMapper.findAllByCidCoursedetails(id);
        //把获取到数据封装到map
        map.put("course",course);
        map.put("coursedetailList",coursedetailList);

        return map;
    }

    @Override
    public List<Course> findCourseTypeAll(Long typeId){
        return this.baseMapper.findCourseTypeAll(typeId);
    }

}
