package com.itsource.web.controller;

import com.itsource.service.ICourseDetailService;
import com.itsource.domain.CourseDetail;
import com.itsource.query.CourseDetailQuery;
import com.itsource.hrm.util.AjaxResult;
import com.itsource.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseDetail")
public class CourseDetailController {
    @Autowired
    public ICourseDetailService courseDetailService;

    /**
    * 保存和修改公用的
    * @param courseDetail  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody CourseDetail courseDetail){
        try {
            if(courseDetail.getId()!=null){
                courseDetailService.updateById(courseDetail);
            }else{
                courseDetailService.insert(courseDetail);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            courseDetailService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CourseDetail get(@PathVariable("id")Long id)
    {
        return courseDetailService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<CourseDetail> list(){

        return courseDetailService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<CourseDetail> json(@RequestBody CourseDetailQuery query)
    {
        Page<CourseDetail> page = new Page<CourseDetail>(query.getPage(),query.getRows());
        page = courseDetailService.selectPage(page);
        return new PageList<CourseDetail>(page.getTotal(),page.getRecords());
    }
}
