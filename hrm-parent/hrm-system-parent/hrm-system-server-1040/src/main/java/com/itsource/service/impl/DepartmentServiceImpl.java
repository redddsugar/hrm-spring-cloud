package com.itsource.service.impl;

import com.itsource.domain.Department;
import com.itsource.mapper.DepartmentMapper;
import com.itsource.service.IDepartmentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liu
 * @since 2021-08-06
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
