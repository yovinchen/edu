package com.offcn.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offcn.edu.dao.CourseUserMapper;
import com.offcn.edu.pojo.CourseUser;
import com.offcn.edu.service.CourseUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
@Service
public class CourseUserServiceImpl extends ServiceImpl<CourseUserMapper, CourseUser> implements CourseUserService {

    @Override
    public CourseUser findEqualByCidUid(Integer cid,Integer uid){
        return this.baseMapper.findEqualByCidUid(cid,uid);
    }

    @Override
    public List<CourseUser> findCourseUserByUid(Integer cid) {
        return this.baseMapper.findCourseUserByUid(cid);
    }
}
