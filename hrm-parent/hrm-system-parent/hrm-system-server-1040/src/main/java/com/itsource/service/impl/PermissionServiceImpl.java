package com.itsource.service.impl;

import com.itsource.domain.Permission;
import com.itsource.mapper.PermissionMapper;
import com.itsource.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
