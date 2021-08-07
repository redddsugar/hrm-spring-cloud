package com.itsource.mapper;

import com.itsource.domain.Tenant;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liu
 * @since 2021-08-06
 */
public interface TenantMapper extends BaseMapper<Tenant> {
    Tenant selectByCompanyName(String companyName);
}
