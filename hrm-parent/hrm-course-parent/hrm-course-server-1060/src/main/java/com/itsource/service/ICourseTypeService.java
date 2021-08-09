package com.itsource.service;

import com.itsource.domain.CourseType;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author Liu
 * @since 2021-08-09
 */
public interface ICourseTypeService extends IService<CourseType> {

    /**
     * 查询所有的课程类型 并按树状展示
     * @return List<CourseType>
     */
    List<CourseType> treeData();
}
