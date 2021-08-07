package com.itsource.service.impl;

import com.itsource.domain.Menu;
import com.itsource.mapper.MenuMapper;
import com.itsource.service.IMenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
