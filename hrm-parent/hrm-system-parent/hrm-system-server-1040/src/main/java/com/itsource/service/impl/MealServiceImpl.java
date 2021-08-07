package com.itsource.service.impl;

import com.itsource.domain.Meal;
import com.itsource.mapper.MealMapper;
import com.itsource.service.IMealService;
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
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements IMealService {

}
