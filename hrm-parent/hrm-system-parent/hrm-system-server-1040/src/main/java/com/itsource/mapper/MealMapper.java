package com.itsource.mapper;

import com.itsource.domain.Meal;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Liu
 * @since 2021-08-06
 */
public interface MealMapper extends BaseMapper<Meal> {

    /**
     * 添加套餐
     * @param mealId
     * @param tenantId
     * @param now
     */
    void addTenantMeal(@Param("mealId") Long mealId, @Param("tenantId") Long tenantId, @Param("now") Date now);
}
