package com.offcn.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offcn.edu.pojo.CourseUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
public interface CourseUserService extends IService<CourseUser> {

    //根据用户编号和课程编号，验证是否购买过该课程
    CourseUser findEqualByCidUid(Integer cid,Integer uid);

    List<CourseUser> findCourseUserByUid(Integer uid);

}
