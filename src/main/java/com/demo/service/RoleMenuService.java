package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.entity.RoleMenuEntity;
import com.demo.common.request.PageFrom;

/**
 * 角色和菜单关联表
 *
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
public interface RoleMenuService extends IService<RoleMenuEntity> {

    PageUtils queryPage(PageFrom params);
}

