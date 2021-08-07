package com.itsource.service.impl;

import com.itsource.domain.TenantType;
import com.itsource.mapper.TenantTypeMapper;
import com.itsource.service.ITenantTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户(机构)类型表 服务实现类
 * </p>
 *
 * @author Liu
 * @since 2021-08-06
 */
@Service
public class TenantTypeServiceImpl extends ServiceImpl<TenantTypeMapper, TenantType> implements ITenantTypeService {

}
