package com.offcn.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offcn.edu.pojo.CourseUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
public interface CourseUserMapper extends BaseMapper<CourseUser> {

    //查询用户是否购买过课程
    CourseUser findEqualByCidUid(@Param("cid") Integer cid, @Param("uid") Integer uid);

    //根据uid获取对应购买课程集合
    List<CourseUser> findCourseUserByUid(@Param("uid") Integer uid);

}
