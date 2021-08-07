package com.itsource.service.impl;

import com.itsource.domain.Employee;
import com.itsource.domain.Tenant;
import com.itsource.hrm.util.StrUtils;
import com.itsource.hrm.util.ValidUtils;
import com.itsource.hrm.util.encrypt.MD5;
import com.itsource.mapper.EmployeeMapper;
import com.itsource.mapper.MealMapper;
import com.itsource.mapper.TenantMapper;
import com.itsource.service.ITenantService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.itsource.vo.TenantVO;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liu
 * @since 2021-08-06
 */

@Transactional
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {
    @Autowired(required = false)
    EmployeeMapper employeeMapper;
    @Autowired(required = false)
    MealMapper mealMapper;

    @Override
    public void entering(TenantVO tenantVO) {
        Tenant tenant = tenantVO.getTenant();
        Employee employee = tenantVO.getEmployee();
        Long mealId = tenantVO.getMealId();

        //1. 验证参数
        ValidUtils.assertNotNull(tenant.getCompanyName(), "公司名称不可以为空");
        ValidUtils.assertNotNull(tenant.getTenantTypeId(), "公司类别不可以为空");
        ValidUtils.assertEmail(employee.getEmail(), "邮箱格式不正确");
        ValidUtils.assertPhone(employee.getTel(), "手机号格式不正确");
        ValidUtils.assertNull(baseMapper.selectByCompanyName(tenant.getCompanyName()), "公司名不可以重复！");

        //2. 保存数据
        //2.1 先保存机构，获取id 如果前台没有传递属性，我们需要提供默认值
        System.out.println(tenantVO);

        Date now = new Date();
        tenant.setRegisterTime(now);
        tenant.setState(0);

        baseMapper.insert(tenant);

        //2.2 在保存员工，密码，加盐加密
        String salt = StrUtils.getComplexRandomString(8);
        String password = employee.getPassword();

        employee.setSalt(salt);
        employee.setPassword(MD5.getMD5(password+salt));
        employee.setInputTime(now);
        employee.setState(0);

        // 机构ID
        employee.setTenantId(tenant.getId());
        employee.setType(5);
        employeeMapper.insert(employee);

        //2.3 保存套餐关系 该机构的该套餐到期时间, 试用7天
        Date expireDate = DateUtils.addDays(now,7);
        mealMapper.addTenantMeal(mealId,tenant.getId(),expireDate);
    }
}
