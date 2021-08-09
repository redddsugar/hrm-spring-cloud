package com.itsource.domain;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程目录
 * </p>
 *
 * @author Liu
 * @since 2021-08-09
 */
@Data
@TableName("t_course_type")
public class CourseType extends Model<CourseType> {

    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<CourseType> children = new ArrayList<>(); //子级列表

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("create_time")
    private Long createTime;
    @TableField("update_time")
    private Long updateTime;
    /**
     * 类型名
     */
    private String name;
    /**
     * 父ID
     */
    private Long pid;
    /**
     * 图标
     */
    private String logo;
    /**
     * 描述
     */
    private String description;
    @TableField("sort_index")
    private Integer sortIndex;
    /**
     * 路径
     */
    private String path;
    /**
     * 课程数量
     */
    @TableField("total_count")
    private Integer totalCount;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
