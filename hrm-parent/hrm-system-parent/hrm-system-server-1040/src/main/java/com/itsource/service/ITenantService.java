package com.itsource.service;

import com.itsource.domain.Tenant;
import com.baomidou.mybatisplus.service.IService;
import com.itsource.vo.TenantVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Liu
 * @since 2021-08-06
 */
public interface ITenantService extends IService<Tenant> {

    /**
     * 机构入驻
     * @param tenantVO
     */
    void entering(TenantVO tenantVO);
}
