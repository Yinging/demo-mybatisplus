package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.entity.MenuEntity;
import com.demo.common.request.PageFrom;

/**
 * 菜单权限表
 *
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
public interface MenuService extends IService<MenuEntity> {

    PageUtils queryPage(PageFrom params);
}

