package com.offcn.edu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offcn.edu.pojo.Coursedetail;
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
public interface CoursedetailMapper extends BaseMapper<Coursedetail> {
    //根据课程编号 cid获取对应课程详情集合
    List<Coursedetail> findAllByCidCoursedetails(@Param("cid") Long cid);
}
