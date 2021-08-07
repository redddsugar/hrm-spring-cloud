package com.itsource.web.controller;

import com.itsource.service.ITenantService;
import com.itsource.domain.Tenant;
import com.itsource.query.TenantQuery;
import com.itsource.hrm.util.AjaxResult;
import com.itsource.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import com.itsource.vo.TenantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Good idea
 */
@RestController
@RequestMapping("/tenant")
public class TenantController {
    @Autowired
    public ITenantService tenantService;

    /**
     * 保存和修改公用的
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxResult save(@RequestBody Tenant tenant) {
        if (tenant.getId() != null) {
            tenantService.updateById(tenant);
        } else {
            tenantService.insert(tenant);
        }
        return AjaxResult.me();
    }

    /**
     * 删除对象信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id) {
        tenantService.deleteById(id);
        return AjaxResult.me();
    }

    /**
     *获取用户
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tenant get(@PathVariable("id") Long id) {
        return tenantService.selectById(id);
    }


    /**
     * 查看所有的员工信息
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Tenant> list() {
        return tenantService.selectList(null);
    }


    /**
     * 分页查询数据
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @RequestMapping(value = "/pagelist", method = RequestMethod.POST)
    public PageList<Tenant> json(@RequestBody TenantQuery query) {
        Page<Tenant> page = new Page<Tenant>(query.getPage(), query.getRows());
        page = tenantService.selectPage(page);
        return new PageList<Tenant>(page.getTotal(), page.getRecords());
    }

    @PostMapping("/entering")
    public AjaxResult entering(@RequestBody TenantVO tenantVO) {
        tenantService.entering(tenantVO);
        return AjaxResult.me().setSuccess(true);
    }
}
