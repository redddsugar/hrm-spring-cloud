package com.itsource.service.impl;

import com.itsource.domain.CourseType;
import com.itsource.mapper.CourseTypeMapper;
import com.itsource.service.ICourseTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author Liu
 * @since 2021-08-09
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {

    @Override
    public List<CourseType> treeData() {
        List<CourseType> fatherList = new ArrayList<>();
        List<CourseType> all = baseMapper.selectList(null);
        all.forEach(e -> {
            if (e.getPid() == 0L) {
                fatherList.add(e);
            } else {
                all.forEach(father -> {
                    if (e.getPid().equals(father.getId())) {
                        father.getChildren().add(e);
                    }
                });
            }
        });

        return fatherList;
    }
}
